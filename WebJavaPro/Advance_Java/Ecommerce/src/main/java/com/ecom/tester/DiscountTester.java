package com.ecom.tester;

import static com.ecom.utils.EcommerceUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.ecom.dao.ProductDao;
import com.ecom.dao.ProductDaoImpl;
import com.ecom.entities.Category;
import com.ecom.entities.Product;

public class DiscountTester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner (System.in); SessionFactory s = getFactory()){
			ProductDao productdao = new ProductDaoImpl();
			System.out.println("Enter Quantity: ");
int qty = sc.nextInt();
			
			System.out.println("Enter discount value: ");
			double discount = sc.nextDouble()/100;
			productdao.applyDiscount(qty,discount);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
