package com.health.pojo;

import java.sql.Date;

public class Patient {
//	| id | name| email| password | phone| dob|

	
	private int id;
	private String pname;
	private String pemail;
	private String ppassword;
	private String phone;
	private Date pdob;
	@Override
	public String toString() {
		return "Patients [id=" + id + ", pname=" + pname + ", pemail=" + pemail + ", ppassword=" + ppassword
				+ ", phone=" + phone + ", pdob=" + pdob + "]";
	}
	public Patient(int id, String pname, String pemail, String ppassword, String phone, Date pdob) {
		super();
		this.id = id;
		this.pname = pname;
		this.pemail = pemail;
		this.ppassword = ppassword;
		this.phone = phone;
		this.pdob = pdob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPpassword() {
		return ppassword;
	}
	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getPdob() {
		return pdob;
	}
	public void setPdob(Date pdob) {
		this.pdob = pdob;
	}
}
