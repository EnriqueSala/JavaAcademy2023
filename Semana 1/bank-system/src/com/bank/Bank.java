package com.bank;

import java.math.BigDecimal;

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
	
	//Adds an account object to the accounts list (ArrayList)
	 public void createAccount(AbstractUser user, BigDecimal balance){
		Account account = new Account(balance);
		user.addAccount(account);
	}
	
}
