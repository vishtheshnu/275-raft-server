package coordination;

import io.atomix.AtomixClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proxy.ProxyServer;
import raft.Config;

import java.io.IOException;
import java.util.HashMap;

/**
 * Starts a grpc server with the defined proto file implementations
 */
public class GrpcServer{

	protected static Logger LOG = LoggerFactory.getLogger(GrpcServer.class.getName());
	private Server server;
	private AtomixClient raftClient;

	private HashMap<String, Object> storage;

	public GrpcServer(AtomixClient client, HeartbeatService hbService){
		System.out.println("Inside grpc server constructor");
		raftClient = client;
		server = ServerBuilder.forPort(Config.coordServerPort)
				.addService(new InternalFileTransferImpl(storage, hbService))
				.addService(new ExternalFileTransferImpl(storage, hbService))
				.build();
		System.out.print("initialized server");
	}

	public void startServer(){
		LOG.debug("Starting GRPC Server...");
		try {
			server.start();
			System.out.println("Started Server!");
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
		LOG.debug("GRPC Server started...");
	}
}
