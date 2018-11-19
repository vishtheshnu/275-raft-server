package grpc;

import io.atomix.AtomixClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import raft.Config;

import java.io.IOException;

/**
 * Starts a grpc server with the defined proto file implementations
 */
public class GrpcServer{

	private Server server;
	private AtomixClient raftClient;

	public GrpcServer(AtomixClient client){
		server = ServerBuilder.forPort(Config.coordServerPort)
				.addService(new InternalFileTransferImpl(raftClient))
				.addService(new ExternalFileTransferImpl(raftClient))
				.build();
		raftClient = client;
	}

	public void startServer(){
		try {
			server.start();
			server.awaitTermination();
		}catch (IOException e){
			System.err.println("IO excpetion with starting the grpc server!");
			e.printStackTrace();
			System.exit(1);
		}catch (InterruptedException e){
			System.err.println("Interrupt excpetion with awaiting termination of the grpc server!");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
