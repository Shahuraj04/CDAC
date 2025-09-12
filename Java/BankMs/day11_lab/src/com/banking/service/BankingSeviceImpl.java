package com.banking.service;

import java.util.ArrayList;

import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;
import static com.banking.validations.BankingValidations.validateAllInputs;

public class BankingSeviceImpl implements BankingService {
    
    private ArrayList<BankAccount> list;

    public BankingSeviceImpl() {
        this.list = new ArrayList<>();  
    }

    @Override
    public String openAccount(int accountNumber, double balance, String customerName,
                              String phoneNumber, String acType, String dob,
                              double rateOrLimit) throws BankingException {
        BankAccount newAcc = validateAllInputs(accountNumber, balance, customerName,
                                               phoneNumber, acType, dob, rateOrLimit, list);
        list.add(newAcc);  
        return "Account Registered!! Thank You\n" + newAcc.toString();
    }

    @Override
    public void getSummary(int accountNo) throws BankingException {
        for (BankAccount acc : list) {
            if (accountNo == acc.getAccountNumber())
            	System.out.println(acc);
                return ;
        }
        throw new BankingException("Account not found!");
    }

    @Override
    public void withdraw(int accountNo, double amount) throws BankingException {
       for(BankAccount acc : list) {
    	   if(accountNo == acc.getAccountNumber()) {
    		   acc.withdraw(amount);
    	   }
       }
    }

    @Override
    public void deposit(int accountNo, double amount) throws BankingException {
    	for(BankAccount acc : list) {
     	   if(accountNo == acc.getAccountNumber()) {
     		   acc.deposit(amount);
     	   }
        }
    }
    
    @Override
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("No accounts available!");
        } else {
            for (BankAccount acc : list) {
                System.out.println(acc);
            }
        }
    }

}
