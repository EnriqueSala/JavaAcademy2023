package abstractinterface;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance;

	
	
	
	public Account(BigDecimal balance) {
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
