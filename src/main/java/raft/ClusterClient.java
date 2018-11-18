package raft;

import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;

import java.util.Arrays;
import java.util.List;

public class ClusterClient {

	public static void main(String [] args) throws Exception{
		List<Address> clusterAddresses = Arrays.asList(
				new Address("localhost", 8700),
				new Address("localhost", 8701),
				new Address("localhost", 8702)
		);

		AtomixClient client = AtomixClient.builder()
				.withTransport(new NettyTransport())
				.build();


		client.connect(clusterAddresses).join();
		/*

		client.connect(clusterAddresses).thenRun(
				() -> {
					client.getMap("fileLocations").thenCompose(m -> m.put("bar", "helloWorld"))
							.thenRun(() -> System.out.println("Value stored in distributed map!"));
				}
		);

		client.connect(clusterAddresses).thenRun(
				() -> {
					String value = "Error occured";
					try {
						value = client.getMap("fileLocations")
								.thenCompose(m -> m.get("bar"))
								.thenApply(a -> (String) a)
								.get();
					}catch(Exception e){
						e.printStackTrace();
					}
					System.out.println("Retrieved value of bar: "+value);
				}
		);
*/

		String value = client.getMap("fileLocations")
				.thenCompose(m -> m.get("bar"))
				.thenApply(a -> (String) a)
				.get();
		System.out.println("Retrieved value of bar: "+value);

		//String fakeval = client.getMap("fileLocations").thenCompose(m ->m.get("foo"))
		//		.thenApply(a -> (String) a).get();

		//System.out.println("Undefined value of foo: "+fakeval);
	}
}
