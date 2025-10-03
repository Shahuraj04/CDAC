package com.ecommerce.validations;

import java.util.List;

import com.ecommerce.core.Category;
import com.ecommerce.core.Customer;
import com.ecommerce.core.Product;
import com.ecommerce.customException.DuplicateProductException;
import com.ecommerce.customException.InvalidCredentialsException;

public class validateAll {
	
	
	public static Customer validateLogin(String mail,String pswd,List<Customer> customerList) throws InvalidCredentialsException {
		for(Customer c : customerList) {
			if(c.getCemail().equals(mail) && c.getCpswd().equals(pswd)) {
				return c;
			}
			
		}
		throw new InvalidCredentialsException("Wrong credentials");
		
	}
	public static Customer validateCustomer(String cname, String cemail, String cpswd,List<Customer> customerList) throws InvalidCredentialsException {
		for(Customer c: customerList) {
			if(c.getCname().equals(cname) && c.getCemail().equals(cemail)) {
				throw new InvalidCredentialsException("Customer Already exist");
			}
		}
		
		return new Customer(cname, cemail, cpswd);
		
		
	}
	
	public static Product validatePrd(String name,Category cat,double price,int stock,List<Product> prdList) throws DuplicateProductException {
		validateDuplicatePrd(name,cat,prdList);
		return new Product(name, cat, price, stock);
		
	}

	private static void validateDuplicatePrd(String name, Category cat, List<Product> prdlist)
	        throws DuplicateProductException {
	    for (Product p : prdlist) {
	        if (p.getPrdName().equalsIgnoreCase(name) && p.getCategory().equals(cat)) {
	            throw new DuplicateProductException("Product Already Exist!!!");
	        }
	    }
	}

}
