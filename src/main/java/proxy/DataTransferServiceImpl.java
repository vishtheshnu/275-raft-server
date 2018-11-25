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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import util.Connection;

public class DataTransferServiceImpl extends grpc.DataTransferServiceGrpc.DataTransferServiceImplBase {
	private ProxyServer proxyServer;
	
	private static List<ManagedChannel> dbChannels = new ArrayList<ManagedChannel>();
	
	DataTransferServiceImpl(ProxyServer proxyServer){
        super();
        this.proxyServer = proxyServer;
        initConnections();
    }
	
	public static void initConnections(){
        for(Connection c : ProxyServer.dbServerList){
            ManagedChannel ch = ManagedChannelBuilder.forAddress(c.ipAddress, c.port)
            		.usePlaintext(true).build();
            dbChannels.add(ch);
        }
	}
        
   
//DownloadChunk (between external client and proxy server)
@Override
	public void downloadChunk(grpc.FileTransfer.ChunkInfo request,
	        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileMetaData> responseObserver) {
		String fileName = request.getFileName();
		long chunkId = request.getChunkId();
		long startSeqNum = request.getStartSeqNum();
		
		MongoClient mongoClient = null;
		 try {
             mongoClient = new MongoClient(Arrays.asList(new ServerAddress(ProxyServer.dbServerList.get(0).ipAddress, ProxyServer.dbServerList.get(0).port),
                     new ServerAddress(ProxyServer.dbServerList.get(1).ipAddress, ProxyServer.dbServerList.get(1).port),
                     new ServerAddress(ProxyServer.dbServerList.get(2).ipAddress, ProxyServer.dbServerList.get(2).port)));
         } catch (UnknownHostException e) {
             e.printStackTrace();
         }
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
	}

//	UploadFile (Not supported yet/between external client and proxy server)
	 @Override
	    public io.grpc.stub.StreamObserver<grpc.FileTransfer.FileUploadData> uploadFile(
	        io.grpc.stub.StreamObserver<grpc.FileTransfer.FileInfo> responseObserver) {
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

	                    MongoClient mongoClient = null;
	                    try {
	                        mongoClient = new MongoClient(Arrays.asList(new ServerAddress(ProxyServer.dbServerList.get(0).ipAddress, ProxyServer.dbServerList.get(0).port),
	                                new ServerAddress(ProxyServer.dbServerList.get(1).ipAddress, ProxyServer.dbServerList.get(1).port),
	                                new ServerAddress(ProxyServer.dbServerList.get(2).ipAddress, ProxyServer.dbServerList.get(2).port)));
	                    } catch (UnknownHostException e) {
	                        e.printStackTrace();
	                    }
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
	                }
	               };
	            }
}

