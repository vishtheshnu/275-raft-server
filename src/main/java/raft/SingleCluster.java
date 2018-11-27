package raft;

import io.atomix.AtomixReplica;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.copycat.server.storage.Storage;
import io.atomix.copycat.server.storage.StorageLevel;

import java.io.File;
import java.net.InetAddress;
import java.util.concurrent.CompletableFuture;

/**
 * Used to create a single node on a localhost cluster. Paramater: int - number of node. Starts at 0
 */
public class SingleCluster {

	private static final int BASE_PORT = 8700;

	public static void main(String [] args){
		System.out.print("Args: ");
		for(String s : args){
			System.out.print(s+" ");
		}
		System.out.println("\n\n");

		if(args.length == 0){
			System.err.println("Insufficient arguments! Need 1 integer" +
					" argument denoting the index of the server's address" +
					" in config.json");
			System.exit(1);
		}

		//Initialize the configuration file, load values
		new Config();

		//Get address and set up node
		Address address = Config.raftAddresses.get(Integer.parseInt(args[0]));
		System.out.println("This node's address: "+address);

		SingleCluster myNode = new SingleCluster();
		boolean isHost = false;
		if(address.port() == 8700)
			isHost = true;
		myNode.createCluster(address.host(), address.port(), false);

		System.out.println("Created node and joined cluster");
	}

	public void createCluster(String host, int port, boolean isHost){

				final Storage storage = Storage.builder()
						.withDirectory(new File("logs"))
						.withStorageLevel(StorageLevel.DISK)
						.build();

				AtomixReplica replica = AtomixReplica.builder(
						new Address(host, port))
						.withStorage(storage)
						.withTransport(new NettyTransport())
						.build();

				if(isHost) {
					CompletableFuture<AtomixReplica> future = replica.bootstrap();
					future.join();
				}
				else {
					replica.join(Config.raftAddresses).join();
				}



	}
}
