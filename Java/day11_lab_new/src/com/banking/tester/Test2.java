package com.banking.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;
import com.banking.service.BankingService;
import com.banking.service.BankingSeviceImpl;

import com.banking.validations.BankingValidations;

public class Test2 {

	public static void main(String[] args) throws BankingException {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("___________WELCOME TO CDAC BANK___________");
			
			
			boolean exit = false;
			
			while(!exit) {
				System.out.println("1. Open account"
						+ "2. Get Account Summary"
						+ "3. Display All"
						+ "4. withdraw"
						+ "5. Deposite"
						+ "0. Exit");
				System.out.println("Enter Choice: ");
				switch(sc.nextInt()) {
				case 1:
					//int accountNumber, double balance, String customerName, String phoneNumber, String acType,
					//String dob, double rateOrLimit
					System.out.print("Enter Account Number: ");
					int accNum = sc.nextInt();
					System.out.print("Enter Balance : ");
					double accBalance = sc.nextDouble();
					System.out.print("Enter Customer name: ");
					String name = sc.next();
					System.out.print("Phone Number : ");
					String pNo = sc.next();
					System.out.print("Enter Account Type : ");
					String type = sc.next();
					System.out.print("Dob(yyyy-mm-dd): ");
					String dob = sc.next();
					System.out.print("Enter Interest rate for saving Account & OverdraftLimit for Current Account : ");
					double rate = sc.nextDouble();
					BankingService b1 = new BankingSeviceImpl();
					System.out.println(" "+ b1.openAccount(accNum, accBalance, name, pNo, type, dob, rate));
					break;
				
				
				}
				
				
				
				
			}
			
			
			
			
			
			
		}

	}

}
