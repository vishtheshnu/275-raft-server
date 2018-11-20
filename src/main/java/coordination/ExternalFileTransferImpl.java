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
