package coordination;

import grpc.DataTransferServiceGrpc;
import grpc.FileTransfer;
import io.atomix.AtomixClient;
import io.grpc.stub.StreamObserver;

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
	public void ListFiles(FileTransfer.RequestFileList request, StreamObserver<FileTransfer.FileList> responseObserver){

	}

	//RequestFileUpload (though uploading is not supported, just return a list of all proxies)
	public void RequestFileUpload(FileTransfer.FileUploadInfo request, StreamObserver<FileTransfer.ProxyList> responseObserver){

	}
}
