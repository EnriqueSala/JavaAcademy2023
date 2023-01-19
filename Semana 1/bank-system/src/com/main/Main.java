package com.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bank.Account;
import com.bank.Bank;
import com.bank.PremiumUser;
import com.bank.RegularUser;
import com.bank.User;

public class Main {

	public static void main(String[] args) {
		//Create the list of users and create and fill a list of amounts for testing
				List<User> abstractUsers = new ArrayList<>();
				ArrayList<BigDecimal> amounts = new ArrayList<BigDecimal>() {
					{
					add(new BigDecimal(5000));
					add(new BigDecimal(5100));
					add(new BigDecimal(3000));
					add(new BigDecimal(9000));
					add(new BigDecimal(15000));
					}
				};
				
				//Get the bank Instance
				Bank bank = Bank.getBankInstance();
				
				//I create a user and an account to test each case scenario
				//RegularUsers
				RegularUser regular1 = new RegularUser("John Smith","+1-234-567-890" , "johnsmith@gmail.com");
				bank.createAccount(regular1,new BigDecimal(5000));
				abstractUsers.add(regular1);
				
				RegularUser regular2 = new RegularUser("Jane Doe","+1-345-678-901","janedoe@gmail.com");
				
				bank.createAccount(regular2,new BigDecimal(5100));
				abstractUsers.add(regular2);
				
				RegularUser regular3 = new RegularUser("Bob Johnson","+1-456-789-012","bobjohnson@gmail.com");
				bank.createAccount(regular3,new BigDecimal(2000));
				abstractUsers.add(regular3);
				
				//PremiumUsers
				PremiumUser premium1 = new PremiumUser("Emily Davis","emilydavis@gmail.com","+1-567-890-123");
				bank.createAccount(premium1,new BigDecimal(10000));
				abstractUsers.add(premium1);
				
				
				PremiumUser premium2 = new PremiumUser("Andrew Kim","andrewkim@gmail.com", "+1-678-901-234");
				bank.createAccount(premium2,new BigDecimal(10000));
				abstractUsers.add(premium2);
				
				for(int i=0; i<abstractUsers.size(); i++) {
					//I use the withdraw method from the user interface
					//the 0 means the first account of that user
					abstractUsers.get(i).withdraw(0,amounts.get(i));
				}
				
				//this prints the number of Bank instances I have
				System.out.println(Bank.counter);
				
				
				//this is to prove I can't create Accounts without using the bank instance
				//Account account = new Account(new BigDecimal(5000));
			}

	}

