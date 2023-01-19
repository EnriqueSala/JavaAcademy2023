package com.singleton;

public class Main {

	public static void main(String[] args) {
		
		//I declare multiple Bank variables and then print the counter
		//to prove there's only one Bank instance
		Bank user1 = Bank.getBankInstance();
		Bank user2 = Bank.getBankInstance();
		Bank user3 = Bank.getBankInstance();
		Bank user4 = Bank.getBankInstance();
		
		
		System.out.println("Amount of Bank instances " + Bank.counter);
	}

}