package com.ecom.tester;

import static com.ecom.utils.EcommerceUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.ecom.dao.ProductDao;
import com.ecom.dao.ProductDaoImpl;
import com.ecom.entities.Product;

public class FilterByDateAndEnumTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory s = getFactory()) {
			ProductDao productdao = new ProductDaoImpl();
			System.out.println("Enter Date: ");
			String date = sc.next();
			System.out.println("Enter category: ");
			String category= sc.next();
			
			productdao.filterByDateAndCategory(date, category).forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
