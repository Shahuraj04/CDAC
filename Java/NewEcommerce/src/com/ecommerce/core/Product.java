package com.ecommerce.core;

public class Product {
	
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	private static int counter=1000;
	private int prdId;
	private String prdName;
	private Category category;
	private double price;
	private int stock;
	public Product(String prdName, Category category, double price, int stock) {
		
		this.prdId =++counter ;
		this.prdName = prdName;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [prdId=" + prdId + ", prdName=" + prdName + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + "]";
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Product product = (Product) o;
	    return prdName.equalsIgnoreCase(product.prdName) 
	            && category == product.category;
	}
	
	
	
	

}
