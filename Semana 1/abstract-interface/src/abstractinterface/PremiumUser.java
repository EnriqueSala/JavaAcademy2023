package abstractinterface;

import java.math.BigDecimal;

public class PremiumUser extends AbstractUser {
	
	public PremiumUser(String name, String phone, String email) {
		super(name, phone, email);
	}

	//Interface methods
	@Override
	public void whithdraw(int accountNumber, BigDecimal amount) {
		
		//I get the account object I'm gonna be working with and it's balance
		Account account = this.accounts.get(accountNumber);
		BigDecimal balance = account.getBalance();
		
		
		//If the balance in the account is higher or equal to the amount given
		if (balance.compareTo(amount) >= 0){
			
			//first I substract the amount from the account
			account.setBalance(balance.subtract(amount));
			
			//and then I print the result
			System.out.println("Premium user: you withdrew " + amount +
					" your balance now is "+account.getBalance());
		}else
			System.out.println("Premium user: the transactions isn't possible");
	}

}