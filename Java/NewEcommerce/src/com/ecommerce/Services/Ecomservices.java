package com.ecommerce.Services;

import java.util.List;

import com.ecommerce.core.Category;
import com.ecommerce.core.Product;
import com.ecommerce.customException.DuplicateProductException;
import com.ecommerce.customException.InvalidCredentialsException;

public interface Ecomservices {

	void addProduct() throws DuplicateProductException;
	void displayAllproducts();
	void registerCustomer() throws InvalidCredentialsException;
	void customerLogin() throws InvalidCredentialsException;
	String placeOrder() throws InvalidCredentialsException;
	void showOrders();

}
