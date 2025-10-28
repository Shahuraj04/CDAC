package com.ecom.dao;

import java.util.List;

import com.ecom.entities.Product;

public interface ProductDao {

	String addProduct(Product product);

	Product displayDetailsById(Long id);

	List<Product> filterByDateAndCategory(String date, String category);

	String changePrice(String prdName, double price);
	
	String applyDiscount(int qty,double dicount);

}
