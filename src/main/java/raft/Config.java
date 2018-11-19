package raft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.atomix.catalyst.transport.Address;
import org.json.*;

public class Config {

	public static List<Address> raftAddresses;
	public static List<Address> proxyAddresses;

	public Config(){
		Scanner scan = null;
		try {
			scan = new Scanner(new File("src/config.json"));
		} catch (FileNotFoundException e){
			System.err.println("Configuration file \"clusterAddresses.conf\" not found! Closing program");
			System.exit(1);
		}

		String cfgStr = "";
		while(scan.hasNext()){
			cfgStr += scan.nextLine();
		}
		JSONObject config = new JSONObject(cfgStr);

		//Populate values
		raftAddresses = new ArrayList<Address>();
		JSONArray addr = config.getJSONArray("clusterAddresses");
		for(int i = 0; i < addr.length(); i++){
			JSONObject obj = addr.getJSONObject(i);
			raftAddresses.add(new Address(obj.getString("host"),
					obj.getInt("port")));
		}

		proxyAddresses = new ArrayList<Address>();
		addr = config.getJSONArray("proxyAddresses");
		for(int i = 0; i < addr.length(); i++){
			JSONObject obj = addr.getJSONObject(i);
			proxyAddresses.add(new Address(obj.getString("host"),
					obj.getInt("port")));
		}
	}


}
