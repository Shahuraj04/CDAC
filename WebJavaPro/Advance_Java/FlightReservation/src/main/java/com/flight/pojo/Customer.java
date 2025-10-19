package com.flight.pojo;

import java.security.PrivateKey;
import java.sql.Date;

public class Customer {
	private int id;
	private String customer_f_name;
	private String customer_l_name;
	private String customer_email;
	private String cutomer_password;
	private String customer_phno;
	
	public Customer(int id, String customer_f_name, String customer_l_name, String customer_email,
			String cutomer_password, String customer_phno, Date cutomer_dob, int card_id) {
		super();
		this.id = id;
		this.customer_f_name = customer_f_name;
		this.customer_l_name = customer_l_name;
		this.customer_email = customer_email;
		this.cutomer_password = cutomer_password;
		this.customer_phno = customer_phno;
		this.cutomer_dob = cutomer_dob;
		this.card_id = card_id;
	}

	public String getCustomer_phno() {
		return customer_phno;
	}

	public void setCustomer_phno(String customer_phno) {
		this.customer_phno = customer_phno;
	}

	private Date cutomer_dob;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_f_name=" + customer_f_name + ", customer_l_name=" + customer_l_name
				+ ", customer_email=" + customer_email + ", cutomer_password=" + cutomer_password + ", customer_phno="
				+ customer_phno + ", cutomer_dob=" + cutomer_dob + ", card_id=" + card_id + "]";
	}

	public Customer(int id, String customer_f_name, String customer_l_name, String customer_email,
			String cutomer_password, Date cutomer_dob, int card_id) {
		super();
		this.id = id;
		this.customer_f_name = customer_f_name;
		this.customer_l_name = customer_l_name;
		this.customer_email = customer_email;
		this.cutomer_password = cutomer_password;
		this.cutomer_dob = cutomer_dob;
		this.card_id = card_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_f_name() {
		return customer_f_name;
	}

	public void setCustomer_f_name(String customer_f_name) {
		this.customer_f_name = customer_f_name;
	}

	public String getCustomer_l_name() {
		return customer_l_name;
	}

	public void setCustomer_l_name(String customer_l_name) {
		this.customer_l_name = customer_l_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCutomer_password() {
		return cutomer_password;
	}

	public void setCutomer_password(String cutomer_password) {
		this.cutomer_password = cutomer_password;
	}

	public Date getCutomer_dob() {
		return cutomer_dob;
	}

	public void setCutomer_dob(Date cutomer_dob) {
		this.cutomer_dob = cutomer_dob;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	private int card_id;
}
