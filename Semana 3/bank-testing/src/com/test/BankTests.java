package com.test;
import org.junit.jupiter.api.Test;
import abstractinterface.Account;
import abstractinterface.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BankTests {
	
	//Both branches of a successful withdraw
	@Test
	public void testValidWithdraw1() {
		//Create the necessary objects for the class
		User user = new User("John Smith", "+1-234-567-890", "johnSmith@gmail.com");
		Account account = new Account(new BigDecimal(5000));
		user.addAccount(account);
		BigDecimal amount = new BigDecimal(5000);
		
		//Test of a successful withdrawal
		user.withdraw(0, amount);
		assertEquals("Balance after withdraw should be 0", new BigDecimal(0), account.getBalance());
		
		}
	@Test
	public void testValidWithdraw2() {
		//Create the necessary objects for the class
		User user = new User("John Smith", "+1-234-567-890", "johnSmith@gmail.com");
		Account account = new Account(new BigDecimal(5000));
		user.addAccount(account);
		BigDecimal amount = new BigDecimal(3000);
		
		//Test of a successful withdrawal
		user.withdraw(0, amount);
		assertEquals("Balance after withdraw should be 2000", new BigDecimal(2000), account.getBalance());
		
		}
	
	//Both branches of a unsuccessful withdraw
	//trying to withdraw more money than balance
	@Test
	public void testInvalidWithdraw1() {
		//Create the necessary objects for the class
		User user = new User("John Smith", "+1-234-567-890", "johnSmith@gmail.com");
		Account account = new Account(new BigDecimal(5000));
		user.addAccount(account);
		BigDecimal amount = new BigDecimal(15000);
		
		//Test of a unsuccessful withdrawal
		user.withdraw(0, amount);
		assertEquals("Balance after withdraw should be the same", new BigDecimal(5000), account.getBalance());
		
		}
	
	//Trying to withdraw more money than permitted
	@Test
	public void testInvalidWithdraw2() {
		//Create the necessary objects for the class
		User user = new User("John Smith", "+1-234-567-890", "johnSmith@gmail.com");
		Account account = new Account(new BigDecimal(6000));
		user.addAccount(account);
		BigDecimal amount = new BigDecimal(6000);
		
		//Test of a unsuccessful withdrawal
		user.withdraw(0, amount);
		assertEquals("Balance after withdraw should be the same", new BigDecimal(6000), account.getBalance());
		
		}

	@Test
	public void testAddAccount() {
		User user = new User("John Doe", "555-555-555", "johndoe@example.com");
		Account account = new Account(new BigDecimal(10000));
		user.addAccount(account);
		
		ArrayList<Account> accounts = user.getAccounts();
		assertTrue("User should have one account", accounts.size() == 1);
		assertEquals("Account balance should be 10000", new BigDecimal(10000), accounts.get(0).getBalance());
	}
}