package raft;

import java.io.Serializable;

public class TestStoreObj implements Serializable{
	String s;
	int i;

	public TestStoreObj(int i, String s){
		this.s = s;
		this.i = i;
	}

	@Override
	public String toString(){
		return i+" , "+s;
	}
}
