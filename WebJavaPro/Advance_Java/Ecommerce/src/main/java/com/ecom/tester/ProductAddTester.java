package com.ecom.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.ecom.dao.ProductDao;
import com.ecom.dao.ProductDaoImpl;
import com.ecom.entities.Category;
import com.ecom.entities.Product;

import static com.ecom.utils.EcommerceUtils.getFactory;

public class ProductAddTester {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner (System.in); SessionFactory s = getFactory()){
			ProductDao productdao = new ProductDaoImpl();
			Product p = new Product("prd", "desc", LocalDate.parse("2001-12-12"), 122, 2, Category.SHOES);
			productdao.addProduct(p);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
