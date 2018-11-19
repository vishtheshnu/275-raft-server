package coordination;

import com.cmpe275.generated.*;
import io.atomix.AtomixClient;
import io.grpc.stub.StreamObserver;

public class InternalFileTransferImpl extends clusterServiceGrpc.clusterServiceImplBase {

	private AtomixClient raftClient;
	public InternalFileTransferImpl(AtomixClient client){
		super();
		raftClient = client;
	}

	//Liveliness (This file sends the message to proxies)

	//updateChunkData (From edge to This Coordination server)
	public void updateChunkData(ChunkData request, StreamObserver<ChunkDataResponse> responseObserver){

	}

	//isFilePresent (From edge to This coordination server)
	public void isFilePresent(FileQuery request, StreamObserver<FileResponse> responseObserver){

	}

	//uploadFileChunk (From client to proxy; not needed here!)

}
