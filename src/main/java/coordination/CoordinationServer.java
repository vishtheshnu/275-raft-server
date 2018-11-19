package coordination;

import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import raft.Config;
import raft.TestStoreObj;

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

		//testConnection(client);

		//Initialize Heartbeat service
		HeartbeatService hbservice = new HeartbeatService();
		hbservice.startHeartbeatService();

		//Initialize gRPC server
		grpcServer = new GrpcServer(client, hbservice);
		grpcServer.startServer();

		System.out.println("Created grpc server! Now testing connection to raft server");


	}

	public static void testConnection(AtomixClient client) throws Exception{
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
