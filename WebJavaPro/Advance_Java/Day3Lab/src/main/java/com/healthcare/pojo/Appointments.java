package com.healthcare.pojo;

import java.sql.Date;

public class Appointments {

	//mysql> select * from appointments;
//	+----+-----------+------------+----------------------+-----------+
//	| id | doctor_id | patient_id | appointment_datetime | status    |
	
	private int id ;
	private int doc_id;
	private int pat_id;
	private Date date;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public int getPat_id() {
		return pat_id;
	}
	public void setPat_id(int pat_id) {
		this.pat_id = pat_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Appointments(int doc_id, int pat_id, Date date, String status) {

		this.doc_id = doc_id;
		this.pat_id = pat_id;
		this.date = date;
		this.status = status;
	}
	
}
