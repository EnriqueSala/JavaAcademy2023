package com.bank;
import java.util.ArrayList;

//POLYMORPHISM

//Abstract class with the attributes all users have
public abstract class AbstractUser implements User {
	String name;
	String phone;
	String email;
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	//We first need to create the user to add accounts 
	//so we don't use accounts in the constructor
	public AbstractUser(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	//Adds an account object to the accounts list (ArrayList)
	void addAccount(Account account){
		this.accounts.add(account);
	}
	
}