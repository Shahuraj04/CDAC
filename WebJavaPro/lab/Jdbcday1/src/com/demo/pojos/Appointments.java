package com.demo.pojos;

import java.sql.Date;

public class Appointments {
//+----+-----------+------------+----------------------+-----------+
///	| id | doctor_id | patient_id | appointment_datetime | status    |
///
 private int id;
 private int docid;
 private int patId;
 private Date aDate;
 private String status;
public Appointments(int id, int docid, int patId, Date aDate, String status) {
	super();
	this.id = id;
	this.docid = docid;
	this.patId = patId;
	this.aDate = aDate;
	this.status = status;
}
@Override
public String toString() {
	return "Appointments [id=" + id + ", docid=" + docid + ", patId=" + patId + ", aDate=" + aDate + ", status="
			+ status + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getDocid() {
	return docid;
}
public void setDocid(int docid) {
	this.docid = docid;
}
public int getPatId() {
	return patId;
}
public void setPatId(int patId) {
	this.patId = patId;
}
public Date getaDate() {
	return aDate;
}
public void setaDate(Date aDate) {
	this.aDate = aDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	
	
}
