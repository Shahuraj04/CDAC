	package com.ecommerce.services;
	
	import java.util.ArrayList;
	
	import com.ecommerce.CustomException.ECommerceException;
	import com.ecommerce.core.Category;
	import com.ecommerce.core.Customer;
	import com.ecommerce.core.OrderItem;
	import com.ecommerce.core.Product;
	
	public class ECommerceServiceImpl implements ECommerceService {
	
		private ArrayList<Customer> list = new ArrayList<>();
		private ArrayList<Product> prdList = new ArrayList<>();
		private ArrayList<OrderItem> ordList = new ArrayList<>();
		
	
		public ECommerceServiceImpl() {
			this.list = new ArrayList<>();
			this.prdList = new ArrayList<>();
			this.ordList = new ArrayList<>();
			list.add(new Customer("Shahuraj", "shahu@gmail.com", "123"));
			list.add(new Customer("Tony", "john@gmail.com", "456"));
			list.add(new Customer("Doe", "doe@gmail.com", "4789"));
			prdList.add(new Product("Jeans", 500, 10, Category.CLOTHING));
			prdList.add(new Product("Tshirt", 500, 10, Category.CLOTHING));
			prdList.add(new Product("Mobile", 500, 10, Category.ELECTRONICS));
		}
	
		@Override
		public String registerCustomer(int custId, String custName, String email, String password) {
	
			Customer newCust = new Customer(custName, email, password);
			list.add(newCust);
			return "Customer Registered!!";
		}
	
		@Override
		public String customerLogin(String email, String pswd) throws ECommerceException {
	//		for (Customer c : list) {
	//			if (c.getEmail().equals(email) && c.getPassword().equals(pswd)) {
	//				return "Login Successful!!!";
	//			}
	//		}
	//		return " Invalid Credwntials";
			Customer c = new Customer(email);
			int index = list.indexOf(c);
			if (index == -1)
				throw new ECommerceException("Invalid Email!!");
	
			Customer complete = list.get(index);
			if (!complete.getPassword().equals(pswd)) {
				throw new ECommerceException("Invalid password!!!");
			}
			return "Login Successful!!!";
	
		}
	
		@Override
		public String placeOrder(String email, int prdId, int quantity) {
	
			Customer tempCustomer = new Customer(email);
			int customerIndex= list.indexOf(tempCustomer);
			
			Customer customer  = list.get(customerIndex);
			
			Product orderedPrd = null;
			for(Product p : prdList  ) {
				
				if(p.getPrdId() == prdId ) {
					orderedPrd = p;
					break;
				}
				
			}
			double totalPrice = quantity*orderedPrd.getPrice();
			OrderItem Item = new OrderItem(customer, orderedPrd, quantity, totalPrice) ;
			
			ordList.add(Item);
			customer.getOrderList().add(Item);
			
			
			return "Order Placed";
			
		}
	
		@Override
		public void displayAll() {
		    for (Customer c : list) {
		        if (!c.getOrderList().isEmpty()) {   // ✅ only show if orders exist
		            System.out.println("\nCustomer: " + c.getCustName() + " (" + c.getEmail() + ")");
		            for (OrderItem item : c.getOrderList()) {
		                System.out.println("   " + item);
		            }
		        }
		    }
		}

	
		@Override
		public void addProduct(String prdName, String prdType, double price) throws ECommerceException {
	
			Category category = Category.valueOf(prdType.toUpperCase());
	
			Product dummyPrd = new Product(prdName, 0, 0, category);
	
			if (prdList.contains(dummyPrd)) {
				throw new ECommerceException("Product already exists with name and category!!");
			}
	
			Product prd = new Product(prdName, price, 10, category);
			prdList.add(prd);
			System.out.println("Product added: " + prd);
	
		}
	
		@Override
		public void showAllprd() {
			if (prdList.isEmpty()) {
				System.out.println("No accounts available!");
			} else {
				for (Product pr : prdList) {
					System.out.println(pr);
				}
			}
	
		}
	
	}