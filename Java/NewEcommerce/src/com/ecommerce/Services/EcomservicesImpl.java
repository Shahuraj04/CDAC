package com.ecommerce.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ecommerce.core.Category;
import com.ecommerce.core.Customer;
import com.ecommerce.core.Order;
import com.ecommerce.core.Product;
import com.ecommerce.customException.DuplicateProductException;
import com.ecommerce.customException.InvalidCredentialsException;
import com.ecommerce.validations.validateAll;

public class EcomservicesImpl implements Ecomservices {
	Scanner sc = new Scanner(System.in);

	private List<Product> prdList;
	private List<Customer> customerList;
	private List<Order> orderList;

	public EcomservicesImpl() throws DuplicateProductException {
		prdList = new ArrayList<>();
		customerList = new ArrayList<>();
		orderList = new ArrayList<>();

		Product p = validateAll.validatePrd("SHIRT", Category.CLOTHING, 800, 5, prdList);
		prdList.add(p);
	}

	@Override
	public void addProduct() throws DuplicateProductException {
		System.out.print("Enter Product name: ");
		String name = sc.next();

		System.out.print("Enter Category (CLOTHING/ELECTRONICS/etc): ");
		String cat = sc.next().toUpperCase();
		Category category = Category.valueOf(cat);

		System.out.print("Enter Product price: ");
		double price = sc.nextDouble();

		System.out.print("Enter Product stock: ");
		int stock = sc.nextInt();

		Product p = validateAll.validatePrd(name, category, price, stock, prdList);
		prdList.add(p);
		System.out.println(" Product added successfully!");
	}

	@Override
	public void displayAllproducts() {
		if (prdList.isEmpty()) {
			System.out.println("No products available.");
		} else {
			for (Customer c : customerList)
				System.out.println(c);
			for (Product p : prdList) {
				System.out.println(p);

			}
			for(Order o : orderList) {
				System.out.println(o);
			}
		}
	}

	@Override
	public void registerCustomer() throws InvalidCredentialsException {
		System.out.println("Enter Customer namee: ");
		String cname = sc.next();
		System.out.println("Enter Customer Email: ");
		String cmail = sc.next();
		System.out.println("Enter Password: ");
		String cpswd = sc.next();

		Customer c = validateAll.validateCustomer(cname, cmail, cpswd, customerList);
		customerList.add(c);

	}

	@Override
	public void customerLogin() throws InvalidCredentialsException {
		System.out.println("Enter email : ");
		String emailCheck = sc.next();
		System.out.println("Enter Password: ");
		String pswdCheck = sc.next();
		System.out.println(validateAll.validateLogin(emailCheck, pswdCheck, customerList));
	}

	@Override
	public String placeOrder() throws InvalidCredentialsException{
		System.out.println("Enter email : ");
		String emailCheck = sc.next();
		System.out.println("Enter Password: ");
		String pswdCheck = sc.next();
		Customer loggedInCustomer = validateAll.validateLogin(emailCheck, pswdCheck, customerList);
		System.out.println(validateAll.validateLogin(emailCheck, pswdCheck, customerList));
		System.out.println("Enter product ID: ");
		int orderPId = sc.nextInt();
		System.out.println("Enter Quantity: ");
		int orderqty = sc.nextInt();
		Product selectedProduct = null;
		for(Product p :prdList) {
			if(orderPId==p.getPrdId()) {
				selectedProduct=p;
			}
		}
		Order order = new Order(orderPId, loggedInCustomer.getCname());
		orderList.add(order);
		return "Order Placed";
		
	}

	@Override
	public void showOrders() {
		// TODO
	}

}
