package coordination;

import com.cmpe275.generated.*;
import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.grpc.stub.StreamObserver;
import raft.Config;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class InternalFileTransferImpl extends clusterServiceGrpc.clusterServiceImplBase {

	private AtomixClient raftClient;
	private HeartbeatService heartbeat;

	public InternalFileTransferImpl(AtomixClient client, HeartbeatService hbService){
		super();
		raftClient = client;
		heartbeat = hbService;
	}

	//Liveliness (This file sends the message to proxies)

	//updateChunkData (From edge to This Coordination server)
	public void updateChunkData(ChunkData request, StreamObserver<ChunkDataResponse> responseObserver){

		String mapvalue = null;
		try {
			mapvalue = raftClient.getMap("fileLocations")
					.thenCompose(m -> m.get(request.getFileName()+"_"+request.getChunkId()))
					.thenApply(a -> (String) a)
					.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		String[] arr = mapvalue.split(",");
		arr[4]= "true";

		ChunkDataResponse response = ChunkDataResponse.newBuilder()
				.setChunkId(request.getChunkId())
				.setIsAvailable(true)
				.setFileName(request.getFileName())
				.build();

		responseObserver.onNext(response);

		responseObserver.onCompleted();

	}

	//isFilePresent (From edge to This coordination server)
	public void isFilePresent(FileQuery request, StreamObserver<FileResponse> responseObserver){

		String mapvalue = null;
		try {
			mapvalue = raftClient.getMap("fileLocations").thenCompose(m -> m.get(request.getFileName()+"_0"))
					.thenApply(a -> (String) a)
					.get();


		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		String[] arr = mapvalue.split(",");

		FileResponse response = null;

		if("true".equals(arr[4])){
			 response = FileResponse.newBuilder()
					.setIsFound(true)
					.build();
		}else{
			response = FileResponse.newBuilder()
					.setIsFound(false)
					.build();
		}


		responseObserver.onNext(response);
		responseObserver.onCompleted();

	}

	//uploadFileChunk (From client to proxy; not needed here!)

}
