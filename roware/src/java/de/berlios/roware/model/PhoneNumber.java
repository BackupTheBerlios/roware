package de.berlios.roware.model;

/**
 * @author Joachim Praetorius
 */


public class PhoneNumber {

	private String number = null;
	private int type = 0;

	public PhoneNumber(){
	}
	
	public PhoneNumber(String number,int type){
		this.number = number;
		this.type = type;
	}

	public void setNumber(String n){
		number = n;	
	}

	public void setType(int t){
		type = t;
	}
	
	public String getNumber(){
		return number;
	}
	
	public int getType(){
		return type;
	}
}

