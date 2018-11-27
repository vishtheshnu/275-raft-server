package coordination;

import com.cmpe275.generated.*;
import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.grpc.stub.StreamObserver;
import org.apache.log4j.Logger;
import raft.Config;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class InternalFileTransferImpl extends clusterServiceGrpc.clusterServiceImplBase {

	private HashMap<String, Object> storage;
	private HeartbeatService heartbeat;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Logger logger = Logger.getLogger(InternalFileTransferImpl.class);

	public InternalFileTransferImpl(HashMap<String, Object> storage, HeartbeatService hbService){
		super();
		this.storage = storage;
		heartbeat = hbService;
	}

	@Override
	public void liveliness(Heartbeat request, StreamObserver<Heartbeat> responseObserver) {
		Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method liveliness started at "+ ts1);
		super.liveliness(request, responseObserver);
	}
//Liveliness (This file sends the message to proxies)

	//updateChunkData (From proxy to This Coordination server)
	@Override
	public void updateChunkData(ChunkData request, StreamObserver<ChunkDataResponse> responseObserver){

		Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method updateChunkData started at "+ ts1);
		String mapvalue = null;

		mapvalue = (String)storage.get(request.getFileName()+"_"+request.getChunkId());

		String[] arr = mapvalue.split(",");
		arr[4]= "true";

		ChunkDataResponse response = ChunkDataResponse.newBuilder()
				.setChunkId(request.getChunkId())
				.setIsAvailable(true)
				.setFileName(request.getFileName())
				.build();

		responseObserver.onNext(response);

		responseObserver.onCompleted();
		Timestamp ts2  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method updateChunkData ended at "+ ts2);
		logger.debug("Method updateChunkData execution time : "+ (ts2.getTime() - ts1.getTime()) + "ms");

	}

	//isFilePresent (From edge to This coordination server)
	@Override
	public void isFilePresent(FileQuery request, StreamObserver<FileResponse> responseObserver){


		Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method isFilePresent started at "+ ts1);
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
		Timestamp ts2  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method isFilePresent ended at "+ ts2);
		logger.debug("Method isFilePresent execution time : "+ (ts2.getTime() - ts1.getTime()) + "ms");
	}

	//uploadFileChunk (From client to proxy; not needed here!)

	// initiateFileUpload
	@Override
	  public void initiateFileUpload(com.cmpe275.generated.FileUploadRequest request,
	        io.grpc.stub.StreamObserver<com.cmpe275.generated.FileResponse> responseObserver) {

		Timestamp ts1  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method initiateFileUpload started at "+ ts1);
			System.out.println("initiateFileUpload Method arrived");
	          ArrayList<ChunkData> chunks = new ArrayList<ChunkData>();
	          ArrayList<String> proxies = new ArrayList<String>();
	          ArrayList<String> liveProxies = new ArrayList<String>();
	        
	          
	          String fileName = request.getFileName();
	          long fileSize = request.getSize();
	          long maxChunks = request.getMaxChunks();
	          long requestId = request.getRequestId();

	          for(Address addr : Config.proxyAddresses){
		  			proxies.add(addr.host()+":"+addr.port());
		          }
	          /**
	           * For tests
	           */
//	          proxies.add("localhost:8080");
//	          proxies.add("localhost:8081");
//	          proxies.add("localhost:8082");
//	          proxies.add("localhost:8083");
//	          proxies.add("localhost:8084");
	          
	         System.out.println("Creating a map");
	         raftClient.getMap("fileLocations")
	  		.thenCompose(m -> m.put("bar", "Hello World!"))
	  		.join();
	         
	         String value = "";
				try {
					value = raftClient.getMap("fileLocations")
					          .thenCompose(m -> m.get(fileName + "_0"))
					          .thenApply(a -> (String) a)
					          .get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				}
		  		System.out.println("Retrieved value of bar: "+value);
		  		
		  		FileResponse.Builder responseBuilder = FileResponse.newBuilder();
		  		
		  		//Check if the file is already present
		  		if( value != null) {
		  			responseBuilder.setIsFound(true); // Does not return the field to Client if set false
		  			      
		  		} else {
		  				
		  			boolean[] proxyStatus = heartbeat.getProxyStatus();
		  			
		  			 /**
			           * For tests
			           */
		  			
//		  			boolean[] proxyStatus = { true, false, true, true, false } ;
		  			
		  			int proxyStatusSize = proxyStatus.length;

		  			for(int index=0 ; index<proxyStatusSize; index++) {
		  				if(proxyStatus[index]) {
		  					liveProxies.add(proxies.get(index));
		  				}		  					
		  			}
		  			
			          int n = liveProxies.size(); 
			          
			          if(n== 0) {
			        	  	System.out.println("Cannot upload right now! No live proxies available.");
			        	  	throw new ArithmeticException();
			          } else {
			        	  
				          for(int i=0; i < maxChunks; i++){
				            String uniqueId = fileName + "_" + Integer.toString(i);
				            int hash = uniqueId.hashCode();
				            
				            String allotedProxy = liveProxies.get(Math.abs(hash % n));
				            String[] values = allotedProxy.split(":");
				            String ip = values[0];
				            String port = values[1];

				            System.out.println("ip: " + ip);
				            System.out.println("port: " + port);
				            
				            String mapObject = uniqueId + "," + fileName + "," 
							         + Integer.toString(i) + "," +  Long.toString(maxChunks)
							         + "," + "false" + "," + ip + "," + port;
				            System.out.println("Creating a map");
					         raftClient.getMap("fileLocations")
					  		.thenCompose(m -> m.put(uniqueId, mapObject))
					  		.join();
					         
					         
				            ChunkData eachChunk = ChunkData.newBuilder()
				            .setIsAvailable(false)
				            .setPort(port)
				            .setMaxChunks(maxChunks)
				            .setFileName(fileName)
				            .setChunkId((long)i) // Does not return this field to Client if set to 0
				            .setIp(ip)
				            .build();

				            chunks.add(eachChunk);
				            
				          }

				          responseBuilder.setIsFound(false) // Does not return the field to Client if set false
				          .setRequestId(requestId)
				          .addAllChunks(chunks);
			          }
			          
		  		}
	          
	          FileResponse response = responseBuilder.build();
	          responseObserver.onNext(response);
	          
	        responseObserver.onCompleted();
		Timestamp ts2  =  new Timestamp(System.currentTimeMillis());
		logger.debug("Method initiateFileUpload ended at "+ ts2);
		logger.debug("Method initiateFileUpload execution time : "+ (ts2.getTime() - ts1.getTime()) + "ms");

	    }

}
