package com.bms.core;

import com.bms.customExceptions.BankingExceptions;

public class BankAccount {
    private int accNo;
    private String customerName;
    private String phNo;
    private double balance;
    private AccountType type;

    public BankAccount(int accNo, String customerName, String phNo, double balance, AccountType type) {
        this.accNo = accNo;
        this.customerName = customerName;
        this.phNo = phNo;
        this.balance = balance;
        this.type = type;
    }

     
    public void deposit(double amount) {
        balance += amount;
    }

     
    public void withdraw(double amount) throws BankingExceptions {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new BankingExceptions("Insufficient balance!");
        }
    }

     
    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[Account Number: " + accNo +
               ", Customer Name: " + customerName +
               ", Phone Number: " + phNo +
               ", Balance: " + balance +
               ", Account Type: " + type + "]";
    }
}
