package com.bank;

import java.math.BigDecimal;

public interface User {
	
	public void withdraw(int accountNumber, BigDecimal amount);
	
}
