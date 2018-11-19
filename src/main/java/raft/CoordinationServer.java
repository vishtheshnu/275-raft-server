package raft;

import grpc.GrpcServer;
import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;

import java.util.Arrays;
import java.util.List;

public class CoordinationServer {

	private static GrpcServer grpcServer;

	public static void main(String [] args) throws Exception{
		new Config();
		List<Address> clusterAddresses = Config.raftAddresses;

		//Construct client to communicate with raft server
		AtomixClient client = AtomixClient.builder()
				.withTransport(new NettyTransport())
				.build();

		//Connect with raft server
		client.connect(clusterAddresses).join();

		//Initialize gRPC server
		grpcServer = new GrpcServer(client);


	}

	public void testConnection(AtomixClient client) throws Exception{
		client.getMap("fileLocations")
				.thenCompose(m -> m.put("bar", new TestStoreObj(5, "hey")))
				.join();

		TestStoreObj value = client.getMap("fileLocations")
				.thenCompose(m -> m.get("bar"))
				.thenApply(a -> (TestStoreObj) a)
				.get();
		System.out.println("Retrieved value of bar: "+value);
	}
}
