package de.berlios.roware.model;

/**
 * @author Joachim Praetorius
 */


public class EMail {

	private String address = null;
	private int type = 0;

	public EMail(){
	}
	
	public EMail(String address,int type){
		this.address = address;
		this.type = type;
	}

	public void setAddress(String a){
		address = a;	
	}

	public void setType(int t){
		type = t;
	}
	
	public String getAddress(){
		return address;
	}
	
	public int getType(){
		return type;
	}
}

