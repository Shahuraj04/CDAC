package com.sms.tester;

import java.util.Scanner;

import com.sms.services.SMSServices;
import com.sms.services.SMSServicesImpl;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			SMSServices service = new SMSServicesImpl();

			while (!exit) {
				System.out.println(
						"\n1. Admit Student\n2. Cancel Admission\n3. Search student by mail\n4. List All Students\n5. List students by Course");
				System.out.println("\tEnter Choice: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.print("\nEnter Name: ");
						String name = sc.next();
						System.out.print("Enter email: ");
						String email = sc.next();
						System.out.print("marks: ");
						int marks = sc.nextInt();
						System.out.print("Date of Birth: ");
						String dob = sc.next();
						System.out.print("Enter course: ");
						String type = sc.next();

						service.registerStudent(name, email, marks, dob, type);
						break;
						
					case 2:
						System.out.println("Enter email: ");
						String cancelEmail = sc.next();
						service.cancelByEmail(cancelEmail);
						break;

					case 3:
						System.out.println("Enter email: ");
						String checkMail = sc.next();
						System.out.println(service.checkByEmail(checkMail));
						break;

					case 4:
						service.getAllDetails();
						break;
						
					case 5:
						service.sortByCourse();
						break;

					default:
						System.out.println("Invalid choice, try again.");
					}
					

				}  catch (Exception e) {
				    sc.nextLine(); 
				    System.out.println("Error: " + e.getMessage());
				}


			}

		}

}

}
