package com.banking.tester;

import java.util.Scanner;

import com.banking.custom_exceptions.BankingException;
import com.banking.service.BankingService;
import com.banking.service.BankingSeviceImpl;

public class Test2 {

	public static void main(String[] args) throws BankingException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("___________WELCOME TO CDAC BANK___________");

			BankingService b1 = new BankingSeviceImpl();
			boolean exit = false;

			try {
				while (!exit) {
					System.out.println("1. Open account" + "\n2. Get Account Summary" + "\n3. Display All"
							+ "\n4. withdraw" + "\n5. Deposite" + "\n6. Transfer Funds" + "\n7. Close Account"
							+ "\n8. Sort Account based on type" + "\n9. Sort by account number");
					System.out.println("Enter Choice: ");
					switch (sc.nextInt()) {
					case 1:
						// int accountNumber, double balance, String customerName, String phoneNumber,
						// String acType,
						// String dob, double rateOrLimit
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
						System.out.print(
								"Enter Interest rate for saving Account & OverdraftLimit for Current Account : ");
						double rate = sc.nextDouble();

						System.out.println(" " + b1.openAccount(accNum, accBalance, name, pNo, type, dob, rate));
						break;

					case 2:
						System.out.println("Enter id for Summary: ");
						int summaryId = sc.nextInt();
						b1.getSummary(summaryId);
						break;

					case 3:
						b1.displayAll();
						break;

					case 4:
						System.out.print("Enter Id: ");
						int acNo = sc.nextInt();
						System.out.print("Enter Amount: ");
						double amt = sc.nextDouble();
						b1.withdraw(acNo, amt);
						break;

					case 5:
						System.out.print("Enter Id: ");
						int acNo1 = sc.nextInt();
						System.out.print("Enter Amount: ");
						double amt1 = sc.nextDouble();
						b1.deposit(acNo1, amt1);
						break;

					case 6:
						System.out.print("Enter Account number: ");
						int srcAccountNo = sc.nextInt();
						System.out.print("Enter Account Number to which Funds to be transferred: ");
						int destAccountNo = sc.nextInt();
						System.out.print("Enter Amount to be transfered: ");
						double transferAmt = sc.nextDouble();
						b1.transferFunds(srcAccountNo, destAccountNo, transferAmt);
						break;

					case 7:
						System.out.print("Enter Account number: ");
						int closeId = sc.nextInt();
						b1.closeAccount(closeId);
						break;

					case 8:
						System.out.print("Enter Account type and minimum amount: ");
						String accType = sc.next();
						double minAmount = sc.nextDouble();
						b1.sortByType(accType, minAmount);
						break;
					
					case 9:
						b1.sortByAcctNo();
						break;
					}

				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		}

	}
}
