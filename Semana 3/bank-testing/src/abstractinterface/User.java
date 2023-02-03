package abstractinterface;

import java.math.BigDecimal;
import java.util.ArrayList;

//TODO throw an exception when I try to withdraw less than 1

public class User {
	private String name;
	private String phone;
	private String email;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	private final BigDecimal MAXAMOUNT = new BigDecimal(5000);

	public void withdraw(int accountNumber, BigDecimal amount) {
		// I get the account object I'm gonna be working with and it's balance
		Account account = this.accounts.get(accountNumber);
		BigDecimal balance = account.getBalance();

		// If I have enough balance and the amount is permitted
		if (balance.compareTo(amount) >= 0 && amount.compareTo(MAXAMOUNT) <= 0) {

			// first I substract the amount from the account
			account.setBalance(balance.subtract(amount));

			// and then I print the result
			System.out.println("Regular User: you withdrew " + amount + " your balance now is " + account.getBalance());
		} else
			System.out.println("Regular user: the transactions isn't possible");
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
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