package db;

import util.Connection;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import proxy.ProxyServer;
import java.net.UnknownHostException;
import db.ReplicaSet;

public class ReplicaSet {

	protected MongoClient mongoClient;
	
	public MongoClient initializeMongoClient(){
		 MongoClient mc = null;
		 try {

			  mc = new MongoClient(Arrays.asList(new ServerAddress("10.0.20.1", 27017),
	          new ServerAddress("10.0.20.2", 27017),
	          new ServerAddress("10.0.20.3", 27017),
	          new ServerAddress("10.0.20.4", 27017),
	          new ServerAddress("10.0.20.1", 27018)));

			 
			 //smc = new MongoClient("localhost", 27017);
			  
	      	} catch (UnknownHostException e) {
	      		System.out.println("Error:" + e);
	      		e.printStackTrace();
	      	};
	      	
	      	return mc;
	}
	
	
	public static void main(String [] args) throws Exception {
	      	ReplicaSet rs = new ReplicaSet();
	      	rs.initializeMongoClient();
	      	System.out.println("Mongoo Client established!!");
	}
}