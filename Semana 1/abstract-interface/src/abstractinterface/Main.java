package abstractinterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		//Create the list of users and create and fill a list of amounts for testing
		List<User> abstractUsers = new ArrayList<>();
		
		//List with values to test the methods in a for loop
		ArrayList<BigDecimal> amounts = new ArrayList<BigDecimal>() {
			{
			add(new BigDecimal(5000));
			add(new BigDecimal(5100));
			add(new BigDecimal(3000));
			add(new BigDecimal(9000));
			add(new BigDecimal(15000));
			}
		};
		
		
		//I create a user and an account to test each case scenario
		//RegularUsers
		RegularUser regular1 = new RegularUser("John Smith","+1-234-567-890" , "johnsmith@gmail.com");
		Account account1 = new Account(new BigDecimal(5000));
		regular1.addAccount(account1);
		abstractUsers.add(regular1);
		
		RegularUser regular2 = new RegularUser("Jane Doe","+1-345-678-901","janedoe@gmail.com");
		Account account2 = new Account(new BigDecimal(5100));
		regular2.addAccount(account2);
		abstractUsers.add(regular2);
		
		RegularUser regular3 = new RegularUser("Bob Johnson","+1-456-789-012","bobjohnson@gmail.com");
		Account account3 = new Account(new BigDecimal(2000));
		regular3.addAccount(account3);
		abstractUsers.add(regular3);
		
		//PremiumUsers
		PremiumUser premium1 = new PremiumUser("Emily Davis","emilydavis@gmail.com","+1-567-890-123");
		Account account4 = new Account(new BigDecimal(10000));
		premium1.addAccount(account4);
		abstractUsers.add(premium1);
		
		
		PremiumUser premium2 = new PremiumUser("Andrew Kim","andrewkim@gmail.com", "+1-678-901-234");
		Account account5 = new Account(new BigDecimal(10000));
		premium2.addAccount(account5);
		abstractUsers.add(premium2);
		
		for(int i=0; i<abstractUsers.size(); i++) {
			//I use the withdraw method from the user interface
			//the 0 means the first account of that user
			abstractUsers.get(i).withdraw(0,amounts.get(i));
		}
	}
}
