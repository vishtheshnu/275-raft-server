package coordination;

import com.cmpe275.generated.*;
import io.atomix.catalyst.transport.Address;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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
		//Create a new heartbeat thread for each channel/stub
		for(int i = 0; i < stubs.size(); i++){
			createHBThread(stubs.get(i), i);
		}
		//stub.isFilePresent(null).get()
	}

	private void createHBThread(clusterServiceGrpc.clusterServiceFutureStub stub, int index){
		new Runnable() {
			public void run(){
				boolean flag = true;
				Heartbeat response = null;
				while(flag) {
					try {
						response = stubs.get(0).liveliness(request).get(10, TimeUnit.SECONDS);
					} catch (Exception e) {
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
						synchronized (isProxyAccessible){
							isProxyAccessible[index] = true;
						}
					}
				}
			}
		}.run();
	}
}
