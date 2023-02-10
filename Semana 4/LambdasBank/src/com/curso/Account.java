package com.curso;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance;

	public Account(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	void deposit(BigDecimal amount) {
    	this.setBalance(this.getBalance().add(amount));
    }

	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
}
