package proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import util.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProxyServer {
	protected static Logger LOG = LoggerFactory.getLogger(ProxyServer.class.getName());
    protected static AtomicReference<ProxyServer> instance = new AtomicReference<ProxyServer>();
    protected static Config conf;
    public static String serverConfigString;
    public static List<Connection> dbServerList;

 // host details
    protected static Integer hostPort;
    protected static Long hostID;
    protected static String hostIP;
    
    public ProxyServer(String configArg){
    		ProxyServer.conf = ConfigFactory.load();
        ProxyServer.serverConfigString = configArg;
    }
    
    public static ProxyServer getInstance(String conf){
        instance.compareAndSet(null, new ProxyServer(conf));
        return instance.get();
    }
    
    
    private List<Connection> initDbServerList(Config conf){
        LOG.debug("Initialising Mongo Instances...");
        List<Connection> db_svr_list = new ArrayList<Connection>();

        Connection svr_1 = new Connection(
                            conf.getString(this.serverConfigString+".dbServerList.svrIP_1"),
                            conf.getInt(this.serverConfigString+".dbServerList.svrPort_1"));
        Connection svr_2 = new Connection(
                            conf.getString(this.serverConfigString+".dbServerList.svrIP_2"),
                            conf.getInt(this.serverConfigString+".dbServerList.svrPort_2"));
        Connection svr_3 = new Connection(
                            conf.getString(this.serverConfigString+".dbServerList.svrIP_3"),
                            conf.getInt(this.serverConfigString+".dbServerList.svrPort_3"));

        db_svr_list.add(svr_1);
        db_svr_list.add(svr_2);
        db_svr_list.add(svr_3);
        LOG.debug("Mongo Instances Initialised...");
        return db_svr_list;
    }
    
	private void init() {
        LOG.debug("Starting Proxy server..");
		if (conf == null) {
            throw new RuntimeException("server not configured!");
        }

        String tmp_ip =  conf.getString(this.serverConfigString+".proxyConfig.svrIP");
        if (tmp_ip == null)
            throw new RuntimeException("missing server ID");
        hostIP = tmp_ip;

        Integer tmp_port = conf.getInt(this.serverConfigString+".proxyConfig.svrPort");
        if (tmp_port == null)
            throw new RuntimeException("missing server port");
        hostPort = tmp_port;

        if (hostPort <= 1024)
            throw new RuntimeException("server port must be above 1024");
		
//		dbServerList = initDbServerList(conf);
        LOG.debug("Proxy server started..");
	}
	
	public static Config getConf() {
        return conf;
    }

    public Long getServerID() {
        return hostID;
    }

    public static Integer getServerPort() {
        return hostPort;
    }

    public static String getServerIP(){
        return hostIP;
    }

    public static List<Connection> getDbServerList() {
        return dbServerList;
    }

}
