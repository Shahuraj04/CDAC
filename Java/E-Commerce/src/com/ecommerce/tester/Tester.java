package com.ecommerce.tester;

import java.util.Scanner;

import com.ecommerce.services.ECommerceServiceImpl;

public class Tester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("_______CDAC_KART.COM________");

			ECommerceServiceImpl ecom = new ECommerceServiceImpl();

			boolean exit = false;

			while (!exit) {
				try {
					System.out.print(
							"\n1. Add Product \n2. Display All products \n3. Register Customer.\n4. Customer Login\n5. Place order\n6. View Customer Orders\n7. Exit");
					System.out.print("\n\tEnter Choice: ");
					switch (sc.nextInt()) {
					
					case 1:
						System.out.print("\nEnter Name: ");
						String prdName = sc.next();
						System.out.print("Enter product type: ");
						String prdType = sc.next();
						System.out.print("Enter price : ");
						double prdPrice = sc.nextDouble();
						ecom.addProduct(prdName,prdType,prdPrice);
						break;
						
					
					case 2:
						ecom.showAllprd();
						break;
						
						
						

					case 3:
						System.out.print("Enter Customer id: ");
						int id = sc.nextInt();
						System.out.print("Enter Customer Name: ");
						String name = sc.next();
						System.out.print("Enter Email: ");
						String email = sc.next();
						System.out.print("Enter Password: ");
						String pswd = sc.next();
						ecom.registerCustomer(id, name, email, pswd);
						break;

					case 4:
						System.out.println("-----Customer Login-----");
						System.out.print("\tEnter email: ");
						String mail = sc.next();
						System.out.print("\tEnter Password: ");
						String pass = sc.next();
						System.out.print(ecom.customerLogin(mail, pass));

						break;
						
					case 5:
						System.out.print("Enter Email: ");
						String ordMail = sc.next();
						System.out.print("Enter Product ID: ");
						int prdId = sc.nextInt();
						System.out.print("Quantity: ");
						int prdQty = sc.nextInt();
						ecom.placeOrder(ordMail, prdId, prdQty);
						break;
						

					case 6:
						ecom.displayAll();
						break;

					}

				} catch (Exception e) {
					System.out.println(e.getMessage());

				}

			}

		}

	}

}