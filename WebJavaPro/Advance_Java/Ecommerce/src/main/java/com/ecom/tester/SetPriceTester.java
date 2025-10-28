package com.ecom.tester;

import static com.ecom.utils.EcommerceUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.ecom.dao.ProductDao;
import com.ecom.dao.ProductDaoImpl;
import com.ecom.entities.Product;

public class SetPriceTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory s = getFactory()) {
			ProductDao productdao = new ProductDaoImpl();
			System.out.println("Enter name: ");
			String name=sc.next();
			System.out.println("Enter Price: ");
			double price = sc.nextDouble();
			System.out.println(productdao.changePrice(name, price));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
