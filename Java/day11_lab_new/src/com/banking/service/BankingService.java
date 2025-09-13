package com.banking.service;

import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;

public interface BankingService {
//add a method to open account
	 String openAccount(int accountNumber, double balance, String customerName, String phoneNumber, String acType,
			String dob, double rateOrLimit) throws BankingException ;

	// add a method to get account summary
	void getSummary(int accountNo) throws BankingException;
	// add a method to withdraw funds
	void withdraw(int accountNo, double amount) throws BankingException;
	// add a method to deposit funds
	void deposit(int accountNo, double amount) throws BankingException;
	
	String transferFunds(int srcAcct,int desAcct,double amount) throws BankingException;

	void displayAll();

	String closeAccount(int closeId) throws BankingException;

//	void sortByType(String accType, double minAmount) throws BankingException;

	void sortByType(String accType, double minAmount) throws BankingException;

	void sortByAcctNo();

}
