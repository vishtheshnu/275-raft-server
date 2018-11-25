package proxy;

import io.grpc.*;
import io.grpc.stub.StreamObserver;
import grpc.*;
import grpc.FileTransfer.FileUploadData;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.io.FileInputStream;
import java.io.IOException;

public class testClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:3000")
		        .usePlaintext(true)
		        .build();
	}

}
