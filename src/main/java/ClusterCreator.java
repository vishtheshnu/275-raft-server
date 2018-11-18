import io.atomix.AtomixReplica;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.copycat.server.storage.Storage;
import io.atomix.copycat.server.storage.StorageLevel;

import java.io.File;
import java.util.concurrent.CompletableFuture;

public class ClusterCreator {

	public static void main(String [] args){
		System.out.println("Starting program");

		final Storage storage = Storage.builder()
				.withDirectory(new File("logs"))
				.withStorageLevel(StorageLevel.DISK)
				.build();

		AtomixReplica replica = AtomixReplica.builder(
				new Address("localhost", 8700))
				.withStorage(storage)
				.withTransport(new NettyTransport())
				.build();



		System.out.println("Created replica1");

		new Runnable(){
			public void run(){
				AtomixReplica replica2 = AtomixReplica.builder(
						new Address("localhost", 8701))
						.withStorage(storage)
						.withTransport(new NettyTransport())
						.build();

				System.out.println("Created replica2");
				replica2.join(new Address("localhost", 8700)).join();


			}
		}.run();



		new Runnable(){
			public void run(){
				AtomixReplica replica3 = AtomixReplica.builder(
						new Address("localhost", 8702))
						.withStorage(storage)
						.withTransport(new NettyTransport())
						.build();

				System.out.println("Created replica3");
				replica3.join(new Address("localhost", 8700)).join();
			}
		}.run();

		CompletableFuture<AtomixReplica> future = replica.bootstrap();
		future.join();


	}
}
