//package proxy;
//
//import io.grpc.*;
//import io.grpc.stub.StreamObserver;
//import grpc.*;
//import grpc.FileTransfer.FileUploadData;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.Semaphore;
//import java.util.stream.Stream;
//
//import javax.annotation.Nullable;
//
//import com.cmpe275.generated.Chunk;
//import com.cmpe275.generated.ChunkAck;
//import com.cmpe275.generated.ChunkData;
//import com.cmpe275.generated.FileResponse;
//import com.cmpe275.generated.FileUploadRequest;
//import com.cmpe275.generated.clusterServiceGrpc;
//import com.google.common.util.concurrent.FutureCallback;
//import com.google.common.util.concurrent.Futures;
//import com.google.common.util.concurrent.ListenableFuture;
//import com.typesafe.config.Config;
//import com.typesafe.config.ConfigFactory;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class testClient {
//	
//	private static Logger LOG = LoggerFactory.getLogger(testClient.class.getName());
//    private static Config conf;
//    private static String clientID;
//    private static int clientPort;
//    private static List<ManagedChannel> chList;
//    private static List<DataTransferServiceGrpc.DataTransferServiceFutureStub> stubs;
//    private static Long rpcCount;
//    private static Semaphore limiter;
//    
//    private static void init(){
//    		testClient.conf = ConfigFactory.parseResources("application.conf");
//        LOG.debug("Loaded config file.");
//        testClient.clientID = "10.0.20.1";
//        testClient.clientPort = 3000;
//        testClient.chList = initChList();
////        testClient.stubs = initStubs();
//        testClient.rpcCount = 0l;
//        limiter = new Semaphore(10);
//        LOG.debug("Initialized client data.");
//
//    }
//    
//    
//    private static List<ManagedChannel>initChList(){
//        List<ManagedChannel> chList = new ArrayList<ManagedChannel>();
////        ManagedChannel ch0 = ManagedChannelBuilder.forAddress(
////                testClient.edgeServerList.get(0).ipAddress,
////                testClient.edgeServerList.get(0).port
////        ).build();
////        ManagedChannel ch1 = ManagedChannelBuilder.forAddress(
////                Client.edgeServerList.get(1).ipAddress,
////                Client.edgeServerList.get(1).port
////        ).build();
////        ManagedChannel ch2 = ManagedChannelBuilder.forAddress(
////                Client.edgeServerList.get(2).ipAddress,
////                Client.edgeServerList.get(2).port
////        ).build();
////        ManagedChannel ch3 = ManagedChannelBuilder.forAddress(
////                Client.edgeServerList.get(3).ipAddress,
////                Client.edgeServerList.get(3).port
////        ).build();
//        final ManagedChannel ch0 = ManagedChannelBuilder.forTarget("localhost:3000")
//                .usePlaintext(true)
//                .build();
//        chList.add(ch0);
//        return chList;
//    }
//
//	public static void main(String[] args) throws Exception {
//		testClient.init();
//		// TODO Auto-generated method stub
//		byte[] data = {};
//        try{
//            File file = new File("/Users/Mango/Desktop/files/sample.txt");
//            int size = (int) file.length();
//            data = new byte[size];
//            InputStream is = new FileInputStream(file);
//            is.read(data);
//            is.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileUploadRequest req = FileUploadRequest.newBuilder().setFileName("sample.txt").setMaxChunks(4).setRequestId(new Random().nextInt()).build();
//        FileResponse res = doInitiateFileUpload(req);
//        if(res.getIsFound()){
//            List<ChunkData> chunkDataList = res.getChunksList();
//            for(ChunkData cd: chunkDataList){
//                doUploadFileChunk(cd);
//            }
//        }
//		chList.get(0).shutdownNow();
//		
//	}
//
//	public static void doUploadFileChunk(ChunkData chunkData){
//        try {
//            limiter.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            LOG.error("Could not initiate request due to too many requests.");
//        }
//        LOG.debug("Initiate File Upload started.");
//        int index = getIndex();
//        ManagedChannel ch = chList.get(index);
//        clusterServiceGrpc.clusterServiceStub asyncStub = clusterServiceGrpc.newStub(ch);
//        Chunk chunk = Chunk.newBuilder()
//                        .setFileName(chunkData.getFileName())
//                        .setChunkId(chunkData.getChunkId())
//                        .setMaxChunks(chunkData.getMaxChunks())
//                        .setSeqNum(0)
//                        .setSeqMax(0)
//                        .build();
//        StreamObserver<ChunkAck> responseObserver = new StreamObserver<ChunkAck>() {
//            public void onNext(ChunkAck chunkAck) {
//                LOG.debug("Successfully written chunk: "+chunkAck.getFileName()+chunkAck.getChunkId());
//            }
//
//            public void onError(Throwable t) {
//                Status status = Status.fromThrowable(t);
//                LOG.error("Upload File Chunk failed:", status);
//            }
//
//            public void onCompleted() {
//                LOG.debug("Upload File Chunk completed.");
//            }
//        };
//
//        StreamObserver<Chunk> requestObserver = asyncStub.uploadFileChunk(responseObserver);
//        try{
//            requestObserver.onNext(chunk);
//            limiter.release();
//            rpcCount++;
//
//        } catch(RuntimeException e){
//            requestObserver.onError(e);
//        }
//
//        requestObserver.onCompleted();
//    }
//	
//	public static FileResponse doInitiateFileUpload(FileUploadRequest req){
//        try {
//            limiter.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            LOG.error("Could not initiate request due to too many requests.");
//        }
//        LOG.debug("Initiate File Upload started.");
//        ManagedChannel ch = chList.get(0);
//        clusterServiceGrpc.clusterServiceFutureStub stub = clusterServiceGrpc.newFutureStub(ch);
//        ListenableFuture<FileResponse> res = stub.initiateFileUpload(req);
//        Futures.addCallback(res, new FutureCallback<FileResponse>(){
//            public void onSuccess(@Nullable FileResponse fileResponse){
//                rpcCount++;
//                limiter.release();
//                LOG.debug("Initiate file upload was successful.");
//            }
//            public void onFailure(Throwable throwable){
//                rpcCount++;
//                limiter.release();
//                LOG.error("Initiate file upload failed.");
//            }
//        });
//        FileResponse fileRes = null;
//        try{
//            fileRes = res.get();
//        } catch (Exception e){
//            e.printStackTrace();
//            LOG.error("Error:");
//        }
//        return fileRes;
//
//    }
//	
//	public static int getIndex(){
//        Random rand = new Random();
//        return rand.nextInt(4);
//    }
//}



package proxy;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.cmpe275.generated.clusterServiceGrpc;

import grpc.DataTransferServiceGrpc.DataTransferServiceBlockingStub;
import grpc.FileTransfer.ChunkInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import grpc.FileTransfer.*;

public class testClient {
	public static void main(String[] args) throws Exception {
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:3000")
		        .usePlaintext(true)
		        .build();
		
		clusterServiceGrpc.clusterServiceStub asyncStub = clusterServiceGrpc.newStub(channel);
		DataTransferServiceBlockingStub blockingStub = grpc.DataTransferServiceGrpc.newBlockingStub(channel);
		
		ChunkInfo request = ChunkInfo.newBuilder()
		.setChunkId(2)
		.setFileName("my book")
		.setStartSeqNum(0)
		.build();
		
		Iterator<FileMetaData> fileStreams;
		try {
			fileStreams = blockingStub.downloadChunk(request);
		} catch (StatusRuntimeException ex) {
			  System.out.println("RPC failed");
			  return;
		}
		
		while(fileStreams.hasNext()) {
			FileMetaData fm = fileStreams.next();
			System.out.println(fm.getData());
			System.out.println(fm.getSeqMax());
		}
		 
		
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
}
