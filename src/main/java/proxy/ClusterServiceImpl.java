package proxy;

import com.cmpe275.generated.clusterServiceGrpc;
import com.cmpe275.generated.Chunk;
import com.cmpe275.generated.ChunkAck;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.ServerAddress;

import io.grpc.stub.StreamObserver;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Base64;


public class ClusterServiceImpl extends clusterServiceGrpc.clusterServiceImplBase {
	@Override
	public void liveliness(com.cmpe275.generated.Heartbeat request,
	        io.grpc.stub.StreamObserver<com.cmpe275.generated.Heartbeat> responseObserver) {
	      //TODO
	    }
	
	@Override
	public io.grpc.stub.StreamObserver<com.cmpe275.generated.Chunk> uploadFileChunk(
	        io.grpc.stub.StreamObserver<com.cmpe275.generated.ChunkAck> responseObserver) {
	      return new StreamObserver<Chunk>() {
	    	  	String fileName;
	  		long chunkId;
	  		
	    	  	@Override
	    	  	 public void onNext(Chunk ch){
	    	  		fileName = ch.getFileName();
	    	  		chunkId = ch.getChunkId();
	    	  		long maxChunks = ch.getMaxChunks();
	    	  		long seqNum = ch.getSeqNum();
	    	  		long seqMax = ch.getSeqMax();
	    	  		String data = Base64.getEncoder().encodeToString(ch.getData().toByteArray());
	    	  		
	    	  		 MongoClient mongoClient = null;
	                    try {
	                        mongoClient = new MongoClient(Arrays.asList(new ServerAddress(ProxyServer.dbServerList.get(0).ipAddress, ProxyServer.dbServerList.get(0).port),
	                                new ServerAddress(ProxyServer.dbServerList.get(1).ipAddress, ProxyServer.dbServerList.get(1).port),
	                                new ServerAddress(ProxyServer.dbServerList.get(2).ipAddress, ProxyServer.dbServerList.get(2).port)));
	                    } catch (UnknownHostException e) {
	                        e.printStackTrace();
	                    }
	                    DB db = mongoClient.getDB( "file-storage" );
	                    DBCollection coll = db.getCollection("own-files");
	                    
	                    BasicDBObject findQuery = new BasicDBObject("fileName", fileName)
	                            .append("chunkId", chunkId)
	                            .append("seqMax", seqMax);
	                    DBObject listItem = new BasicDBObject("seqInfo", new BasicDBObject("seqNum", seqNum).append("seqData",data));
	                    DBObject updateQuery = new BasicDBObject("$push", listItem);
	                    
	                    // Upsert Document
	                    coll.update(findQuery, updateQuery, true, false);
	    	  		
	    	  	 }
	    	  	
	    	  	@Override
	    	  	public void onError(Throwable t) {
	    	  		responseObserver.onError(t);
	    	  	}
	    	  	
	    	  	@Override
	    	  	public void onCompleted() {
	    	  		responseObserver.onNext(ChunkAck.newBuilder()
	    	  				.setFileName(fileName)
	    	  				.setChunkId(chunkId)
	    	  				.setDone(true)
	    	  				.build());
	    	  		responseObserver.onCompleted();
	    	  	}
	      };
	    }
}
