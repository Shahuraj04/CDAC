package com.ecommerce.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int custId;
	private String custName;
	private String email;
	private String password;
	private List<OrderItem> orderList;
	private static int custIdGen;

	static {
		custIdGen = 100000;
	}

	public Customer(String custName, String email, String password) {
		this.custId = ++custIdGen;
		this.custName = custName;
		this.email = email;
		this.password = password;
		this.orderList = new ArrayList<>();
	}

	public Customer(String email) {
		this.email = email;
	}

	public int getCustId() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer c = (Customer) o;
			return this.email.equals(c.email);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", password=" + password
				+ "]";
	}
}
