package com.developer;
//Fields: accountNumber (int), balance (double) , customer name (String) , phone number (String)
public class BankAccount{
	private int accNo;
	private double balance;
	private String customerName;
	private String phNo;
	
	public BankAccount(int accNo,double balance,String customerName,String phNo) {
		this.accNo=accNo;
		this.setBalance(balance);
		this.customerName = customerName;
		this.phNo = phNo;
	}
	
	public double deposite(double amount) {
			 return this.setBalance(this.getBalance() + amount);
	}
	
	public double withdraw(double amount) {
		return this.setBalance(this.getBalance() - amount);
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getAccountNum() {
		return this.accNo;
	}
	
	public String toString() {
			return "[Account Number: "+this.accNo+" Customer Name: "+this.customerName+" Balance: "+this.getBalance()+" Phone Number: "+this.phNo+"]";
		
	}

	public double setBalance(double balance) {
		this.balance = balance;
		return balance;
	}
	
	
	
	
}