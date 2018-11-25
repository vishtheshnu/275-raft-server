package proxy;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import util.Connection;

import java.io.IOException;


public class ProxyRpcServer {
	private DataTransferServiceImpl dataTransferService;
	private ClusterServiceImpl clusterService;
	private ProxyServer proxyServer;
	private Connection CoordSvr; //TODO Check this
	private Server server;
	
	ProxyRpcServer(String svrConf){
		proxyServer = new ProxyServer(svrConf).getInstance(svrConf);
        dataTransferService = new DataTransferServiceImpl(this.proxyServer);
        clusterService = new ClusterServiceImpl(this.proxyServer);
        server = ServerBuilder.forPort(proxyServer.getServerPort())
                .addService(dataTransferService)
                .addService(clusterService)
                .build();
    }
	
	private void start(){
        try {
            server.start();
            System.out.println("grpc server started");
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
	
	protected void stop() {
        server.shutdown();
    }

    private void blockUntilShutdown() throws Exception {
        server.awaitTermination();
    }

    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Enter one of svr1, svr2, svr3 or svr4 as the command line arg to start.");
        }
        ProxyRpcServer myProxyServer= new ProxyRpcServer(args[0]);
        myProxyServer.start();
        try {
        		myProxyServer.blockUntilShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
