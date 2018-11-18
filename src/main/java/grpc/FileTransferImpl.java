package grpc;

import io.grpc.stub.StreamObserver;

public class FileTransferImpl extends DataTransferServiceGrpc.DataTransferServiceImplBase {

	public void RequestFileInfo(FileTransfer.FileInfo request,
								StreamObserver<FileTransfer.FileLocationInfo> responseObserver){

		String fileName = request.getFileName();

		FileTransfer.FileLocationInfo response = FileTransfer.FileLocationInfo.newBuilder()
				.setFileName(fileName)
				.setMaxChunks(1)
				.setIsFileFound(false)
				.addAllLstProxy(null)
				.build();
	}
}
