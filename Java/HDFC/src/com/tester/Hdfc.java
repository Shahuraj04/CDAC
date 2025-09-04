package com.tester;
import com.developer.*;

class Hdfc{
	public static void main(String[] args) {
		
		BankAccount b1 = new CurrentAccount(1000,2500,"Shahuraj","7385");
		System.out.println(b1.getAccountSummary());
	
	
		b1.withdraw(2500);
		System.out.println(b1.getAccountSummary());
		b1.withdraw(200);
		System.out.println(b1.getAccountSummary());
		b1.withdraw(2500);
		System.out.println(b1.getAccountSummary());
		
	}
	
	
}