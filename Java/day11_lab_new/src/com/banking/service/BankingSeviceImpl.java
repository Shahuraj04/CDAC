package com.banking.service;

import static com.banking.validations.BankingValidations.validateAllInputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;

public class BankingSeviceImpl implements BankingService {

	private ArrayList<BankAccount> list;

	public BankingSeviceImpl() {
		this.list = new ArrayList<>();
		list.add(new BankAccount(101, 15000.0, "Alice Johnson", "9876543210", AccountType.SAVING, LocalDate.of(1995, 5, 10)));
        list.add(new BankAccount(102, 25000.0, "Bob Smith", "9123456780", AccountType.CURRENT, LocalDate.of(1988, 3, 20)));
        list.add(new BankAccount(103, 5000.0, "Charlie Brown", "9988776655", AccountType.SAVING, LocalDate.of(2000, 12, 15)));
        list.add(new BankAccount(104, 80000.0, "Diana Prince", "9001122334", AccountType.SAVING, LocalDate.of(1985, 7, 1)));
        list.add(new BankAccount(105, 120000.0, "Ethan Hunt", "9112233445", AccountType.SAVING, LocalDate.of(1979, 9, 9)));
        list.add(new BankAccount(106, 7000.0, "Fiona Davis", "9223344556", AccountType.SAVING, LocalDate.of(1992, 11, 22)));
        list.add(new BankAccount(107, 45000.0, "George Miller", "9334455667", AccountType.CURRENT, LocalDate.of(1990, 6, 30)));
        list.add(new BankAccount(108, 60000.0, "Hannah Lee", "9445566778", AccountType.SAVING, LocalDate.of(1987, 2, 18)));
        list.add(new BankAccount(109, 3000.0, "Ian Scott", "9556677889", AccountType.SAVING, LocalDate.of(2001, 4, 25)));
        list.add(new BankAccount(110, 95000.0, "Julia Adams", "9667788990", AccountType.CURRENT, LocalDate.of(1993, 8, 14)));
	}

	@Override
	public String openAccount(int accountNumber, double balance, String customerName, String phoneNumber, String acType,
			String dob, double rateOrLimit) throws BankingException {
		BankAccount newAcc = validateAllInputs(accountNumber, balance, customerName, phoneNumber, acType, dob,
				rateOrLimit, list);
		list.add(newAcc);
		return "Account Registered!! Thank You\n" + newAcc.toString();
	}

	@Override
	public void getSummary(int accountNo) throws BankingException {
		for (BankAccount acc : list) {
			if (accountNo == acc.getAccountNumber())
				System.out.println(acc);
			return;
		}
		throw new BankingException("Account not found!");
	}

	@Override
	public void withdraw(int accountNo, double amount) throws BankingException {
		for (BankAccount acc : list) {
			if (accountNo == acc.getAccountNumber()) {
				acc.withdraw(amount);
			}
		}
	}

	@Override
	public void deposit(int accountNo, double amount) throws BankingException {
		for (BankAccount acc : list) {
			if (accountNo == acc.getAccountNumber()) {
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

	@Override
	public String transferFunds(int srcAcct, int desAcct, double transferAmount) throws BankingException {

		BankAccount acct = new BankAccount(srcAcct);
		BankAccount destAccount = new BankAccount(desAcct);
		for (BankAccount acc : list) {
			if (acc.getAccountNumber() == srcAcct) {

				acct = acc;
			}
			if (acc.getAccountNumber() == desAcct) {
				destAccount = acc;
			}
		}
		acct.transfer(destAccount, transferAmount);
		return "Funds transfered";

	}

	@Override
	public String closeAccount(int closeId) throws BankingException {

		BankAccount close = new BankAccount(closeId);
		if (list.remove(close))

			return "Account Closed !!!";
		throw new BankingException("Account Number not found!!!");

	}

	@Override
	public void sortByType(String accType, double minBalane) throws BankingException {

		AccountType myPlan = AccountType.valueOf(accType);
		for (BankAccount b : list) {

			if (b.getAcType().equals(myPlan) && b.getBalance() > minBalane) {
				System.out.println(b.getPhoneNumber());
			}
		}

	}

	@Override
	public void sortByAcctNo() {

		Collections.sort(list);

	}

}
