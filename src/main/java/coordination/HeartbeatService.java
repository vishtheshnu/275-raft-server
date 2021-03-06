package coordination;

import com.cmpe275.generated.*;
import io.atomix.catalyst.transport.Address;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proxy.ProxyServer;
import raft.Config;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Performs the heartbeat
 */
public class HeartbeatService {

	private ArrayList<ManagedChannel> proxyChannels;
	private ArrayList<clusterServiceGrpc.clusterServiceFutureStub> stubs;
	private Heartbeat request;
	private boolean [] isProxyAccessible;
	protected static Logger LOG = LoggerFactory.getLogger(HeartbeatService.class.getName());

	public HeartbeatService(){
		proxyChannels = new ArrayList<ManagedChannel>();
		for(Address addr : Config.proxyAddresses){
			String addrString = addr.host()+":"+addr.port();
			proxyChannels.add(
					ManagedChannelBuilder.forTarget(addrString)
					.usePlaintext(true).build()
			);
		}

		stubs = new ArrayList<clusterServiceGrpc.clusterServiceFutureStub>();
		for(ManagedChannel mc : proxyChannels){
			stubs.add(
					clusterServiceGrpc.newFutureStub(mc)
			);
		}

		request = Heartbeat.newBuilder()
				.setMessageId(0)
				.setIsAck(false)
				.build();

		isProxyAccessible = new boolean[stubs.size()];
	}

	public boolean[] getProxyStatus(){
		synchronized (isProxyAccessible) {
			boolean[] toret = new boolean[isProxyAccessible.length];
			for(int i = 0; i < toret.length; i++)
				toret[i] = isProxyAccessible[i];
			return toret;
		}
	}

	public void startHeartbeatService(){
		LOG.debug("Starting the Hearbeat service between Proxy and Co-ordination server...");
		//Create a new heartbeat thread for each channel/stub
		for(int i = 0; i < stubs.size(); i++){
			System.out.println("Creating HB thread");
			createHBThread(stubs.get(i), i);
			System.out.println("Created HB thread");
		}
		//stub.isFilePresent(null).get()
		LOG.debug("Started the Hearbeat service between Proxy and Co-ordination server...");
	}

	private void createHBThread(clusterServiceGrpc.clusterServiceFutureStub stub, int index){
		Runnable hbrun = new Runnable() {
			public void run(){
				boolean flag = true;
				Heartbeat response = null;
				while(flag) {
					try {
						System.out.println("Sending request for proxy "+index);
						response = stubs.get(index).liveliness(request).get(10, TimeUnit.SECONDS);
					} catch (Exception e) {
						System.out.println("No response/error from proxy "+index);
						//Set to false, sleep for 30 seconds, then retry
						synchronized (isProxyAccessible) {
							isProxyAccessible[index] = false;
						}
						try {
							Thread.sleep(30000);
							continue;
						}catch(InterruptedException interrupt){
							System.err.println("Sleeping thread on heartbeat service for proxy #"+index+
									" interrupted, is this supposed to happen?");
							interrupt.printStackTrace();
						}
					}

					//response is a success, set flag to true
					if(response != null && response.getIsAck()){
						System.out.println("Response from proxy "+index);
						synchronized (isProxyAccessible){
							isProxyAccessible[index] = true;
						}
					}
				}
			}
		};
		(new Thread(hbrun)).start();
	}
}
