package com.health.pojo;

import java.sql.Date;

public class Doctor {
//	 id | name| speciality  | email| password  | dob|

	private int id;
	private String dname;
	private String speciality;
	private String email;
	private String password;
	private Date dob;

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", dname=" + dname + ", speciality=" + speciality + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Doctor(int id, String dname, String speciality, String email, String password, Date dob) {
		super();
		this.id = id;
		this.dname = dname;
		this.speciality = speciality;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

}
