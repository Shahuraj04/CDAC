package com.ecommerce.tester;

import java.util.Scanner;

import com.ecommerce.Services.Ecomservices;
import com.ecommerce.Services.EcomservicesImpl;
import com.ecommerce.core.Category;
import com.ecommerce.customException.DuplicateProductException;
import com.ecommerce.customException.ECommerceException;

public class tester {
	
	public static void main(String[] args) throws DuplicateProductException {
		try(Scanner sc = new Scanner(System.in)){
			
			Ecomservices ec = new EcomservicesImpl();
			boolean exit=false;
			while(!exit) {
				System.out.println("1.Add Product\n2.Display All products\n3.Register Customer\n4.Customer Login\n5.Place Order\n6.View Customer Orders\n7.Cancel order\n8.Exit");
				System.out.println("Enter choice:");
				try {
					switch (sc.nextInt()) {
					case 1: {
						ec.addProduct();
						break;
					}
					case 2:{
						ec.displayAllproducts();
						break;
					}
					case 3:{
						ec.registerCustomer();
						break;
					}
					case 4:{
						ec.customerLogin();
						break;
					}
					case 5:{
						ec.placeOrder();
						break;
					}
					case 6:
						ec.displayAllproducts();
					default:
						
					}
				
					
				}catch (Exception ece) {
					System.out.println(ece.getMessage());
				}
				
				
			}
			
		}
	}

}
