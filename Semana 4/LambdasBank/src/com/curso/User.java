package com.curso;


import java.util.ArrayList;

public class User {
	private String name;
	private String phone;
	private String email;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	

	@Override
	public String toString() {
		return "User [name=" + name + ", phone=" + phone + ", email=" + email + ", accounts=" + accounts + "]";
	}


	public User(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

}
