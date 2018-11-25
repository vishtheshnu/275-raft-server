package proxy;

import com.cmpe275.generated.Heartbeat;
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
import org.apache.log4j.Logger;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;


public class ClusterServiceImpl extends clusterServiceGrpc.clusterServiceImplBase {
	
	private ProxyServer proxyServer;
	
	ClusterServiceImpl(ProxyServer proxyServer){
        super();
        this.proxyServer = proxyServer;
    }

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Logger logger = Logger.getLogger(ClusterServiceImpl.class);


	@Override
	public void liveliness(com.cmpe275.generated.Heartbeat request,
	        io.grpc.stub.StreamObserver<com.cmpe275.generated.Heartbeat> responseObserver) {

		Heartbeat response = Heartbeat.newBuilder()
				.setMessageId(request.getMessageId())
				.setIsAck(true)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	@Override
	public io.grpc.stub.StreamObserver<com.cmpe275.generated.Chunk> uploadFileChunk(
	        io.grpc.stub.StreamObserver<com.cmpe275.generated.ChunkAck> responseObserver) {

		Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method uploadFileChunk started at "+ ts1);
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
					Timestamp ts2  =  new Timestamp(System.currentTimeMillis());
					logger.debug("Method uploadFileChunk ended at "+ ts2);
					logger.debug("Method uploadFileChunk execution time : "+ (ts2.getTime() - ts1.getTime()) + "ms");
	    	  	}

	      };



	    }
}
