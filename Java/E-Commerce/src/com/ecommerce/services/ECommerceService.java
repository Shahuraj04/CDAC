
package com.ecommerce.services;

import java.util.List;

import com.ecommerce.CustomException.ECommerceException;
import com.ecommerce.core.Customer;

public interface ECommerceService{

	
	String registerCustomer(int custId, String custName, String email, String password) throws ECommerceException;

	String customerLogin(String email,String pswd)throws ECommerceException;
	
	String placeOrder(String email,int prdId,int quantity)throws ECommerceException;

	void displayAll()throws ECommerceException;
	
	void addProduct(String prdName,String prdType,double price) throws ECommerceException;

	void showAllprd() throws ECommerceException;
}
