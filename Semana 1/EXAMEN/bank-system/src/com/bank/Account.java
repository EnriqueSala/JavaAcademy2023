package com.bank;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance;

	
	
	//I made the constructor default so it can only be accessed through the package (bank)
	Account(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	
	
	
	//setter and getters
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
