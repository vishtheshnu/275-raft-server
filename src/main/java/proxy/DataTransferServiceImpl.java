package proxy;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.apache.log4j.Logger;
import util.Connection;
import db.ReplicaSet;

public class DataTransferServiceImpl extends grpc.DataTransferServiceGrpc.DataTransferServiceImplBase {
	private ProxyServer proxyServer;
	protected static MongoClient mc;
	
	
//	private static List<ManagedChannel> dbChannels = new ArrayList<ManagedChannel>();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Logger logger = Logger.getLogger(DataTransferServiceImpl.class);
	
	DataTransferServiceImpl(ProxyServer proxyServer){
        super();
        this.proxyServer = proxyServer;
      	ReplicaSet rs = new ReplicaSet();
      	this.mc = rs.initializeMongoClient();
//        initConnections();
    }
	
//	public static void initConnections(){
//        for(Connection c : ProxyServer.dbServerList){
//            ManagedChannel ch = ManagedChannelBuilder.forAddress(c.ipAddress, c.port)
//            		.usePlaintext(true).build();
//            dbChannels.add(ch);
//        }
//	}
        
   
//DownloadChunk (between external client and proxy server)
@Override
	public void downloadChunk(grpc.FileTransfer.ChunkInfo request,
	        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileMetaData> responseObserver) {
	Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
	logger.debug("Method downloadChunk started at "+ ts1);
		String fileName = request.getFileName();
		long chunkId = request.getChunkId();
		long startSeqNum = request.getStartSeqNum();
		
		MongoClient mongoClient = mc;
	
		DB db = mongoClient.getDB( "file-storage" ); 
		DBCollection coll = db.getCollection("files");
		
		DBObject query = new BasicDBObject("fileName", fileName).append("chunkId", chunkId);				
				
		DBCursor cursor = coll.find(query, new BasicDBObject("seqInfo", 1).append("seqMax", 1));	
	
		BasicDBList sequenceList = (BasicDBList) cursor.one().get("seqInfo");
		String maxSeq = (String)cursor.one().get("seqMax");
		 for (int i = 0; i < sequenceList.size(); i++) {
			 BasicDBObject seqObj = (BasicDBObject) sequenceList.get(i);
			 long currentSeq = Long.parseLong(seqObj.getString("seqNum"));
			 if( currentSeq >= startSeqNum && currentSeq <= Long.parseLong(maxSeq)) {
				 //TODO Server Streaming using seqData.toByteArray()
				 grpc.FileTransfer.FileMetaData fileMetaData = grpc.FileTransfer.FileMetaData.newBuilder()
				 .setChunkId(chunkId)
				 .setData(ByteString.copyFrom(Base64.getDecoder().decode(seqObj.getString("seqData"))))
				 .setSeqNum(i)
				 .setSeqMax(Long.parseLong(maxSeq))
				 .build();
				 responseObserver.onNext(fileMetaData);
			 }
		 }
		 responseObserver.onCompleted();
	Timestamp ts2  =  new Timestamp(System.currentTimeMillis());
	logger.debug("Method requestFileInfo ended at "+ ts2);
	logger.debug("Method downloadChunk ended at "+ ts2);
	logger.debug("Method downloadChunk execution time : "+ (ts2.getTime() - ts1.getTime()) + "ms");
	}

//	UploadFile (Not supported yet/between external client and proxy server)
	 @Override
	    public io.grpc.stub.StreamObserver<grpc.FileTransfer.FileUploadData> uploadFile(
	        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileInfo> responseObserver) {

		 Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
		 logger.debug("Method uploadFile started at "+ ts1);
	            return new io.grpc.stub.StreamObserver<grpc.FileTransfer.FileUploadData>() {

	                String fileName;
	                long chunkId;
	                @Override
	                public void onNext(grpc.FileTransfer.FileUploadData fileUploadData){
	                    fileName = fileUploadData.getFileName();
	                    chunkId = fileUploadData.getChunkId();
	                    String data = Base64.getEncoder().encodeToString(fileUploadData.getData().toByteArray());
	                    long seqNum = fileUploadData.getSeqNum();
	                    long seqMax = fileUploadData.getSeqMax();

	                    MongoClient mongoClient = mc;
	                    
	                    DB db = mongoClient.getDB( "file-storage" );
	                    DBCollection coll = db.getCollection("class-files");
	                    
	                    BasicDBObject findQuery = new BasicDBObject("fileName", fileName)
	                            .append("chunkId", chunkId)
	                            .append("seqMax", seqMax);
	                    DBObject listItem = new BasicDBObject("seqInfo", new BasicDBObject("seqNum", seqNum).append("seqData",data));
	                    DBObject updateQuery = new BasicDBObject("$push", listItem);
	                    
	                    //Upsert Document
	                    coll.update(findQuery, updateQuery, true, false);
	                }


	                @Override
	                public void onError(Throwable t) {
	                    responseObserver.onError(t);
	                }

	                @Override
	                public void onCompleted() {
	                    responseObserver.onNext(grpc.FileTransfer.FileInfo.newBuilder()
	                        .setFileName(fileName)
	                        .build());
	                    responseObserver.onCompleted();
						Timestamp ts2  =  new Timestamp(System.currentTimeMillis());
						logger.debug("Method uploadFile ended at "+ ts2);
						logger.debug("Method uploadFile execution time : "+ (ts2.getTime() - ts1.getTime()) + "ms");
	                }
	               };
	            }
}

