package com.developer;
public class CurrentAccount extends BankAccount{
	private double  overdraftLimit=2000;
	
	public CurrentAccount(int accNo,double balance,String customerName,String phNo) {
		super(accNo,balance,customerName,phNo);		
	}
	
	public String useOverdraftFacility() {
		return "hb";
	}
	
	
	public double withdraw(double amount) throws BankException{
	    if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
	        setBalance(getBalance() - amount); // balance can go negative
	        System.out.println("Withdrawn: " + amount);
	        return this.getBalance();
	    } else {
	    	throw new BankException("Insufficeint balance !!");
	        
	    }
	}

	
	
	
	
	
	
}