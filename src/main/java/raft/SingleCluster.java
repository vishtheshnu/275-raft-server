package raft;

import io.atomix.AtomixReplica;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.copycat.server.storage.Storage;
import io.atomix.copycat.server.storage.StorageLevel;

import java.io.File;

/**
 * Used to create a single node on a localhost cluster. Paramater: int - number of node. Starts at 0
 */
public class SingleCluster {

	private static final int BASE_PORT = 8700;

	public static void main(String [] args){
		for(String s : args){
			System.out.println(s);
		}

		SingleCluster myNode = new SingleCluster();
		myNode.createCluster("localhost", BASE_PORT+Integer.parseInt(args[0]));

		System.out.println("Created node and joined cluster");
	}

	public void createCluster(String address, int port){
		new Runnable(){
			public void run(){
				final Storage storage = Storage.builder()
						.withDirectory(new File("logs"))
						.withStorageLevel(StorageLevel.DISK)
						.build();

				AtomixReplica replica = AtomixReplica.builder(
						new Address(address, port))
						.withStorage(storage)
						.withTransport(new NettyTransport())
						.build();

				replica.join(new Address("localhost", BASE_PORT)).join();
				System.out.println("Created cluster (inside createCluster method!)");
			}
		}.run();

	}
}
