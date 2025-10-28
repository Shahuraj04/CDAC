package com.ecom.entities;

import java.time.LocalDate;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	@Column(name="name",length = 50,unique = true)
	private String name;
	@Column(length = 300)
	private String product_desc;
	private LocalDate date;
	private double price;
	private int quantity;
	@Enumerated(EnumType.STRING)
	private Category category;
	
	
	public Product(Long product_id, String name, double price) {
	    this.product_id = product_id;
	    this.name = name;
	    this.price = price;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String product_desc, LocalDate date, double price, int quantity,
			Category category) {
		super();
		this.name = name;
		this.product_desc = product_desc;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", product_desc=" + product_desc + ", date="
				+ date + ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	
}
