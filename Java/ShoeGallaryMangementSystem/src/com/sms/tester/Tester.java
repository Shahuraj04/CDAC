package com.sms.tester;

import java.util.Scanner;

import com.sms.customException.CustomException;
import com.sms.services.ShoeServices;
import com.sms.services.ShoeServicesImpl;

public class Tester {
	public static void main(String[] args) throws CustomException {
		try (Scanner sc = new Scanner(System.in)) {
			ShoeServices service = new ShoeServicesImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println(
						"1.Add new Shoe\n2.Display All shoes\n3.Show by shoe id\n4.Most Expensive shoe\n5.Remove Shoe\n6.Update Shoe Price\n7.Sort by Price\n8.Exit");
				System.out.print("Enter choice:");
				switch (sc.nextInt()) {

				case 1:
					service.getDetails();
				case 2:
					service.showAll();
					break;
				case 3: 
					System.out.println( service.searchById());
					break;
				case 4:
					service.expensiveShoe();
					break;
				case 5:
					System.out.println(service.removeShoe());
					break;
				case 6:
					System.out.println(service.updatePrice());
				case 7:
					service.sortShoe();
					break;

				}

			}
		}

	}

}
