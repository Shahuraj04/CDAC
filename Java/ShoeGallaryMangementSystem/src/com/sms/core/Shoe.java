package com.sms.core;

public class Shoe implements Comparable<Shoe> {
	private static int counter=0;
	private  int shoe_id;
	private String name;
	private  String Brand;
	private int rating;
	private double price;
	private boolean availableInGallery;
	private ShoeType Shoe_type;
	
	public Shoe(String name,String brand,int rating,double price,boolean availableInGallery,ShoeType type) {
		this.shoe_id=++counter;
		this.name=name;
		this.Brand=brand;
		this.rating=rating;
		this.price=price;
		this.availableInGallery=availableInGallery;
		this.Shoe_type=type;
	}

	@Override
	public String toString() {
		return "Shoe [shoe_id=" + shoe_id + ", name=" + name + ", Brand=" + Brand + ", rating=" + rating + ", price="
				+ price + ", availableInGallery=" + availableInGallery + ", Shoe_type=" + Shoe_type + "]";
	}

	@Override
	public int compareTo(Shoe o) {
	    return Double.compare(o.getPrice(), this.getPrice());
	}


	public int getShoe_id() {
		return shoe_id;
	}

	public void setShoe_id(int shoe_id) {
		this.shoe_id = shoe_id;
	}

	public boolean isAvailableInGallery() {
		return availableInGallery;
	}

	public void setAvailableInGallery(boolean availableInGallery) {
		this.availableInGallery = availableInGallery;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
