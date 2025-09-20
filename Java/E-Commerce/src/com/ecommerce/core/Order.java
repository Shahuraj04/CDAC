package com.ecommerce.core;

import java.util.List;

public class Order {
	
		private int orderId;
		private Customer customer;
		private List<OrderItem> orderList;
		
		
		public Order(int orderId, Customer customer, List<OrderItem> orderList) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.orderList = orderList;
		}
		
		
	
}