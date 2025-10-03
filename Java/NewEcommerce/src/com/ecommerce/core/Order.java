package com.ecommerce.core;

import java.util.List;

public class Order {
	
	private static int counter=10000;
	private int orderId;
	private String cname;
	private List<Product> orderList;
	public Order(int orderId, String cname) {
		
		this.orderId = ++counter;
		this.cname = cname;

	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cname=" + cname + ", orderList=" + orderList + "]";
	}
	
	

}
