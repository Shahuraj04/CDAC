//		BankAccount b1 = new CurrentAccount(1000,2500,"Shahuraj","7385");
//		System.out.println(b1.getAccountSummary());
//	
//	
//		b1.withdraw(2500);
//		System.out.println(b1.getAccountSummary());
//		b1.withdraw(200);
//		System.out.println(b1.getAccountSummary());
//		b1.withdraw(2500);
//		System.out.println(b1.getAccountSummary());

package com.tester;

import com.developer.*;

import static java.lang.System.*;
import java.util.Scanner;

class Hdfc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		out.print("Enter size of Bank Branch-CDAC:");
		// create BankAccount array of fixed size
		BankAccount[] Customers = new BankAccount[sc.nextInt()];
		boolean exit = false;
		int count = 0;

		while (!exit) {
			out.println("\n1.Open Savings Account\n" + "2.Open Current Account\n" + "3.Display Account Summary\n"
					+ "4.Deposite\n" + "5.Withdraw\n" + "6.Exit");
			out.print("Enter Choice:");
			switch (sc.nextInt()) {
			case 1:
				if (count < Customers.length) {
					System.out.println("Enter Following Details for Savings Account--->");
					out.print("Enter name: ");
					String name = sc.next();
					out.print("Enter account Number: ");
					int accNo = sc.nextInt();
					boolean accOver = false;
					for (BankAccount sa : Customers) {
						if (sa != null && accNo == sa.getAccountNum()) {
							System.out.print(
									"We already have bank Account with same account number!!! Try different account number!");
							accOver = true;
							break;

						}

					}
					if (!accOver) {

						out.print("Enter Phone number: ");
						String phoneNum = sc.next();
						Customers[count] = new SavingsAccount(accNo, 0.0, name, phoneNum);
						count++;
						out.println("Savings Account Added Successfully!!!!");

					}

					break;
				} else {
					out.println("Account limit reached , come back later");
					break;
				}
			case 2:
				if (count < Customers.length) {
					System.out.println("Enter Following Details for Current Account--->");
					out.print("Enter name: ");
					String name = sc.next();
					out.print("Enter account Number: ");
					int accNo = sc.nextInt();
					boolean accOver = false;
					for (BankAccount sa : Customers) {
						if (sa != null && accNo == sa.getAccountNum()) {
							System.out.print(
									"We already have bank Account with same account number!!! Try different account number!");
							accOver = true;
							break;

						}

					}
					if (!accOver) {

						out.print("Enter Phone number: ");
						String phoneNum = sc.next();
						Customers[count] = new CurrentAccount(accNo, 0.0, name, phoneNum);
						count++;
						out.println("Current Account Added Successfully!!!!");

					}

					break;
				} else {
					out.println("Account limit reached , come back later");
					break;
				}
			case 3:
				out.print("Enter Account number: ");
				int num = sc.nextInt();
				boolean found = false;
				for (BankAccount b : Customers) {

					if (b != null && num == b.getAccountNum()) {

						out.print(b + "\n");
						found = true;
						break;

					}

				}
				if (!found) {
					out.print("Account Not found!!!");
				}
				break;

			case 4:
				out.print("Enter Account number: ");
				int num1 = sc.nextInt();
				boolean found1 = false;

				for (BankAccount b1 : Customers) {
					if (b1 != null && num1 == b1.getAccountNum()) {

						out.print("Enter Deposite amount: ");
						double depAmt = sc.nextDouble();
						b1.deposite(depAmt);
						found1 = true;
						break;
					}

				}
				if (!found1) {
					out.println("Account not found!!!");
				}
				break;

			case 5:
				out.print("Enter Account number: ");
				int num2 = sc.nextInt();
				boolean found3 = false;

				for (BankAccount b2 : Customers) {
					if (b2 != null && num2 == b2.getAccountNum()) {

						out.print("Enter withdraw amount: ");
						double depAmt = sc.nextDouble();
						b2.withdraw(depAmt);
						found3 = true;
						break;
					}

				}
				if (!found3) {
					out.print("Account not found");
				}
				break;
			case 6:
				System.out.print("Terminating Program.......");
				exit = true;

			}

		}

	}

}