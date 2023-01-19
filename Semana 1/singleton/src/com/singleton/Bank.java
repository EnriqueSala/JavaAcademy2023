package com.singleton;

public class Bank {
	//This is so I can prove there's only one Bank instance
	static int counter;
	
	String name;
	private static Bank bank;
	
	//Increase the counter every time I use the constructor (create a bank instance)
	private Bank(String name) {
		this.name = name;
		counter++;
	}
	
	
	public static Bank getBankInstance() {
		if(bank==null)
			bank=new Bank("BBVA");
		return bank;
	}
	
	//Actions only managers/admins should be able to do
	void deleteAccount(int accountId) {
		
	}
	
	void freezeAccount(int accountId) {
		
	}
	
	
}
