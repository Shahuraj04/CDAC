package com.healthcare.pojos;

import java.time.LocalDateTime;

public class Appointments {
	
//	+----+-----------+------------+----------------------+-----------+
//	| id | doctor_id | patient_id | appointment_datetime | status    |
	private int id;
	private int doc_id;
	private int pat_id;
	private LocalDateTime date;
	private String status;
	private String dname;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Appointments(int id, int doc_id, int pat_id, LocalDateTime date, String status, String dname) {
		super();
		this.id = id;
		this.doc_id = doc_id;
		this.pat_id = pat_id;
		this.date = date;
		this.status = status;
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Appointments [id=" + id + ", doc_id=" + doc_id + ", pat_id=" + pat_id + ", date=" + date + ", status="
				+ status + "]";
	}
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
