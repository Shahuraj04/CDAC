package com.bms.service;

import com.bms.core.AccountType;
import com.bms.customExceptions.BankingExceptions;

public interface BMSServices {

    String addAccount(int accNo, String name, String phNo, double initBalance, AccountType type);

    double deposit(int accNo, double amt) throws BankingExceptions;

    double withdraw(int accNo, double amt) throws BankingExceptions;

    String giveSummary();
}
