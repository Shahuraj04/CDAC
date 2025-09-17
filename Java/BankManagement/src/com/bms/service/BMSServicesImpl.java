package com.bms.service;

import com.bms.core.BankAccount;
import com.bms.core.AccountType;
import com.bms.customExceptions.BankingExceptions;

public class BMSServicesImpl implements BMSServices {

    private BankAccount[] accounts;
    private int counter;

    public BMSServicesImpl(int size) {
        this.accounts = new BankAccount[size];
    }

    @Override
    public String addAccount(int accNo, String name, String phNo, double initBalance, AccountType type) {
        if (counter < accounts.length) {
            accounts[counter++] = new BankAccount(accNo, name, phNo, initBalance, type);
            return "Account created successfully!";
        } else {
            return "Account limit reached!";
        }
    }

    @Override
    public double deposit(int accNo, double amt) throws BankingExceptions {
        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccNo() == accNo) {
                acc.deposit(amt);
                return acc.getBalance();
            }
        }
        throw new BankingExceptions("Account not present: " + accNo);
    }

    @Override
    public double withdraw(int accNo, double amt) throws BankingExceptions {
        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccNo() == accNo) {
                if (acc.getBalance() < amt) {
                    throw new BankingExceptions("Insufficient balance in account: " + accNo);
                }
                acc.withdraw(amt);
                return acc.getBalance();
            }
        }
        throw new BankingExceptions("Account not present: " + accNo);
    }

    @Override
    public String giveSummary() {
        StringBuilder sb = new StringBuilder("All Accounts:\n");
        for (BankAccount acc : accounts) {
            if (acc != null) sb.append(acc).append("\n");
        }
        return sb.toString();
    }
}
