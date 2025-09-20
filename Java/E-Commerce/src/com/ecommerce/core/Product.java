package com.ecommerce.core;

public class Product{
	
	public int getPrdId() {
		return prdId;
	}



	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}



	public String getPrdName() {
		return prdName;
	}



	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public Category getType() {
		return type;
	}



	public void setType(Category type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Product [prdId=" + prdId + ", prdName=" + prdName + ", price=" + price + ", stock=" + stock + ", type="
				+ type + "]";
	}



	private int prdId ;
	private String prdName;
	private static int idGenerator;
	private double price;
	private int stock;
	private Category type;
	
	static {
		
		idGenerator=1000;
	}
	
	public Product(String prdName, double price, int stock, Category type) {
		this.prdId=++idGenerator;
		this.prdName = prdName;
		this.price = price;
		this.stock = stock;
		this.type = type;
	}

	
	
	public Product(String prdName2, Category category) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean equals(Object o) {
		
		Product product = (Product)o;
		if( this.prdName.equals(product.prdName) && this.type == product.type ) {
			return true;
		}
		return false;
		
		
	}
	
	
	
	
	
}