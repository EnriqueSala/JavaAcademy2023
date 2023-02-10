package com.curso;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("John Doe","554321212", "test@prueba.com");
        User user2 = new User("Jane Doe", "554321212", "test@prueba.com");
        User user3 = new User("Patrobas", "554321212", "test@prueba.com");
        User user4 = new User("Jorge", "554321212", "test@prueba.com");
        User user5 = new User("Miguel", "554321212", "test@prueba.com");
        Account account1 = new Account(new BigDecimal(1000));
        Account account2 = new Account(new BigDecimal(500));
        Account account3 = new Account(new BigDecimal(1500));
        Account account4 = new Account(new BigDecimal(1300));
        Account account5 = new Account(new BigDecimal(2000));
        user1.addAccount(account1);
        user2.addAccount(account2);
        user3.addAccount(account3);
        user4.addAccount(account4);
        user5.addAccount(account5);
        
        List<User> users = Arrays.asList(user1, user2, user3,user4,user5);
        
        // Using Lambdas to filter accounts based on balance
        System.out.println("Accounts with balance greater than 700:");
        users.stream().filter(a ->a.getAccounts()
        		.get(0)
        		.getBalance()
        		.compareTo(new BigDecimal(700))>0)
        		.forEach(a -> System.out.println(a.getName()));

        // Using Lambdas to perform operations on accounts
        users.forEach(a -> a.getAccounts().get(0).deposit((new BigDecimal(100))));
        users.forEach(a -> System.out.println("Updated balance for " + a.getName() + ": " + 
        a.getAccounts().get(0)));
        
        //Using Lambdas to sort users by the balance on their first account
        List<User> sortedUsers = users.stream()
        		.sorted((u1, u2) -> u1
        				.getAccounts()
        				.get(0).getBalance()
        				.compareTo(u2.getAccounts()
        						.get(0).getBalance()))
        		.collect(Collectors.toList());
        
        //Using lambdas to print the sorted list of users
        sortedUsers.forEach(user -> System.out.println(user.toString()));
        
    
    }
    
    
}

