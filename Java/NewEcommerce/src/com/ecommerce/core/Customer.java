package com.ecommerce.core;

import java.util.List;

public class Customer {
	
	private static int counter=0;
	private int cid;
	private String cname;
	private String cemail;
	private String cpswd;
	private List<Product> ListOfOrders;
	public Customer(String cname, String cemail, String cpswd) {
		this.cid=++counter;
		this.cname = cname;
		this.cemail = cemail;
		this.cpswd = cpswd;
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpswd() {
		return cpswd;
	}
	public void setCpswd(String cpswd) {
		this.cpswd = cpswd;
	}
	public List<Product> getListOfOrders() {
		return ListOfOrders;
	}
	public void setListOfOrders(List<Product> listOfOrders) {
		ListOfOrders = listOfOrders;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpswd=" + cpswd
				+ ", ListOfOrders=" + ListOfOrders + "]";
	}
	
	

}
