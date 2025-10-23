package com.demo.pojos;

import java.sql.Date;

public class Patient {
//| id | name          | email                    | password | phone      | dob        |
	
	private int id;
	private String name;
	private String emali;
	private String password;
	private String phone;
	public Patient(String name, String emali, String password, String phone, Date dob) {
//		| id | name          | email                    | password | phone      | dob        |
		this.name = name;
		this.emali = emali;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
	}
	
	private Date dob;
	
	
	
	public Patient(int id, String name, String emali, String password, String phone, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.emali = emali;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", emali=" + emali + ", password=" + password + ", dob=" + dob
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmali() {
		return emali;
	}
	public void setEmali(String emali) {
		this.emali = emali;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
