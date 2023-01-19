package com.bank;

import java.math.BigDecimal;

public class RegularUser extends AbstractUser {
	
	//Regulars users have a max amount of money they can withdraw
	private final BigDecimal MAXAMOUNT = new BigDecimal(5000);

	public RegularUser(String name, String phone, String email) {
		super(name, phone, email);
	}


	@Override
	public void withdraw(int accountNumber, BigDecimal amount) {
		//I get the account object I'm gonna be working with and it's balance
				Account account = this.accounts.get(accountNumber);
				BigDecimal balance = account.getBalance();
				
				
				//If I have enough balance and the amount is permitted
				if (balance.compareTo(amount) >= 0 && 
						amount.compareTo(MAXAMOUNT) <=0){
					
					//first I substract the amount from the account
					account.setBalance(balance.subtract(amount));
					
					//and then I print the result
					System.out.println("Regular User: you withdrew " + amount +
							" your balance now is "+account.getBalance());
				}else
					System.out.println("Regular user: the transactions isn't possible");
	}
	
}
