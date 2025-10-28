package com.ecom.tester;

import static com.ecom.utils.EcommerceUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.ecom.dao.ProductDao;
import com.ecom.dao.ProductDaoImpl;
import com.ecom.entities.Category;
import com.ecom.entities.Product;

public class DisplayByIdTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory s = getFactory()) {
			ProductDao productdao = new ProductDaoImpl();
			System.out.println("Enter Id: ");
			Product product = productdao.displayDetailsById(sc.nextLong());
			if(product!=null) {
				System.out.println(product);
			}
			else {
				System.out.println("Product not found!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
