package proxy;

import org.apache.log4j.Logger;

import com.cmpe275.generated.clusterServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class TestProxy {

	static Logger LOG = Logger.getLogger(ClusterServiceImpl.class);
    private static long rpcCount =0;
	public static void main(String[] args) throws InterruptedException {
		

	      final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:3000")
	        .usePlaintext(true)
	        .build();

	       clusterServiceGrpc.clusterServiceStub asyncStub = clusterServiceGrpc.newStub(channel);
	        com.cmpe275.generated.Chunk chunk = com.cmpe275.generated.Chunk.newBuilder()
	                .setFileName("")
	                .setChunkId(123)
	                .setMaxChunks(10)
	                .setSeqNum(0)
	                .setSeqMax(0)
	                .build();
	        StreamObserver<com.cmpe275.generated.ChunkAck> responseObserver = new StreamObserver<com.cmpe275.generated.ChunkAck>() {
	            public void onNext(com.cmpe275.generated.ChunkAck chunkAck) {
	                LOG.debug("Successfully written chunk: "+chunkAck.getFileName()+chunkAck.getChunkId());
	            }

	            public void onError(Throwable t) {
	            	t.printStackTrace();
	                Status status = Status.fromThrowable(t);
	                LOG.debug("Upload File Chunk failed:");
	            }

	            public void onCompleted() {
	                LOG.debug("Upload File Chunk completed.");
	            }
	        };
	        
	        StreamObserver<com.cmpe275.generated.Chunk> requestObserver = asyncStub.uploadFileChunk(responseObserver);
	        try{
	            requestObserver.onNext(chunk);
	            Thread.sleep(5000);
	            rpcCount++;

	        } catch(RuntimeException e){
	            requestObserver.onError(e);
	            e.printStackTrace();
	        }
	        requestObserver.onCompleted();
	        channel.shutdownNow();
	       
	 
	}
}
