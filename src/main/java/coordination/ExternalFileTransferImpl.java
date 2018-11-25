package coordination;

import grpc.DataTransferServiceGrpc;
import grpc.FileTransfer;
import io.atomix.AtomixClient;
import io.atomix.collections.DistributedMap;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExternalFileTransferImpl extends DataTransferServiceGrpc.DataTransferServiceImplBase {

	private AtomixClient raftClient;

	public ExternalFileTransferImpl(AtomixClient client){
		super();
		raftClient = client;
	}

	//RequestFileInfo (Used internally by other teams, not us)
	@Override
    public void requestFileInfo(grpc.FileTransfer.FileInfo request,
        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileLocationInfo> responseObserver) {

      String fileName = request.getFileName();
      int maxChunks = 0;

      ArrayList<grpc.FileTransfer.ProxyInfo> proxyList = new ArrayList<grpc.FileTransfer.ProxyInfo>();
      
      grpc.FileTransfer.FileLocationInfo response;
     
      String value = "";
		try {
			value = raftClient.getMap("fileLocations")
			          .thenCompose(m -> m.get(fileName + "_0"))
			          .thenApply(a -> (String) a)
			          .get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		
		if(value == null) {
			response = grpc.FileTransfer.FileLocationInfo.newBuilder()
			        .setFileName(fileName)
			        .setIsFileFound(false)
			        .build();
		} else {
			String [] values = value.split(",");
			maxChunks = Integer.parseInt(values[3]);
			grpc.FileTransfer.ProxyInfo firstProxy = grpc.FileTransfer.ProxyInfo.newBuilder()
					.setIp(values[5])
					.setPort(values[6])
					.build();
			proxyList.add(firstProxy);
			String chunkInfo = "";
			for(int i=1; i<maxChunks; i++) {
				try {
					String uniqueId = fileName + "_" + Integer.toString(i);
					chunkInfo = raftClient.getMap("fileLocations")
					          .thenCompose(m -> m.get(uniqueId))
					          .thenApply(a -> (String) a)
					          .get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				}
				
				if(chunkInfo == null || chunkInfo == "") {
					// TODO: **** isChunkFound required ****
					response = grpc.FileTransfer.FileLocationInfo.newBuilder()
					        .setFileName(fileName)
					        .setIsFileFound(false)
					        .build();
				} else {
					String [] chunkValues = chunkInfo.split(",");
					grpc.FileTransfer.ProxyInfo eachProxy = grpc.FileTransfer.ProxyInfo.newBuilder()
							.setIp(chunkValues[5])
							.setPort(chunkValues[6])
							.build();
					proxyList.add(eachProxy);
				}
				
			}
			
	        response = grpc.FileTransfer.FileLocationInfo.newBuilder()
	        .setFileName(fileName)
	        .setMaxChunks(maxChunks) 
	        .setIsFileFound(true)
	        .addAllLstProxy(proxyList) 
	        .build();
		}
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }



    @Override
	public void GetFileLocation(FileTransfer.FileInfo request,
								StreamObserver<FileTransfer.FileLocationInfo> responseObserver){

		String fileName = request.getFileName();

		FileTransfer.FileLocationInfo response = FileTransfer.FileLocationInfo.newBuilder()
				.setFileName(fileName)
				.setMaxChunks(1)
				.setIsFileFound(false)
				.addAllLstProxy(null)
				.build();
	}

	//DownloadChunk (between external client and proxy server)

	//UploadFile (Not supported yet/between external client and proxy server)

	//ListFiles (between any client and This coordination server)
	@Override
	public void ListFiles(FileTransfer.RequestFileList request, StreamObserver<FileTransfer.FileList> responseObserver) throws ExecutionException, InterruptedException {
		CompletableFuture<DistributedMap<Object, Object>> map = raftClient.getMap("fileLocations");
		Iterator<Map.Entry<Object, Object>> it = raftClient.getMap("fileLocations")
				.thenCompose(m -> m.entrySet())
				.thenApply(a -> a.iterator())
				.get();
		List<String> list = new ArrayList<String>();
		while(it.hasNext()){
			Map.Entry<Object, Object> entry  = it.next();
			String[] value = ((String)entry.getValue()).split(",");
			list.add(value[1]);
		}

		//TODO how to create a builder

	}

	//RequestFileUpload (though uploading is not supported, just return a list of all proxies)
	public void RequestFileUpload(FileTransfer.FileUploadInfo request, StreamObserver<FileTransfer.ProxyList> responseObserver){



	}
}
