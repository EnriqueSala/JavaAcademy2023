package abstractinterface;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance;

	
	
	
	
	//constructor,setter and getters
	public Account(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
