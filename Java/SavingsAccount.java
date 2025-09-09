package com.developer;
public class SavingsAccount extends BankAccount{
	private double interestRate=0.075;
	
	public SavingsAccount(int accNo,double balance,String customerName,String phNo) {
		super(accNo,balance,customerName,phNo);
	}
	
	public double applyInterest() {
		return this.getBalance()*interestRate;
	}
	
	public double withdraw(double amount) throws BankException {
		if(amount>this.getBalance()) {
			throw new BankException("Insufficeint balance !!");
		}
		else {
			setBalance(getBalance() - amount);
			
		}
		return getBalance();
	}
	
	
	
}
