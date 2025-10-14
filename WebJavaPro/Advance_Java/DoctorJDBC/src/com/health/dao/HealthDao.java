package com.health.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.health.pojo.Patient;

public interface HealthDao {
	
	public Patient PatientSignIn(String email,String pswd) throws SQLException;
	public List<Patient> displayByDob(String startDate,String endDate) throws SQLException;
	public String deleltePatient(int id) throws SQLException;
	public String addAppointment(int doc_id,int p_id,String date) throws SQLException;
	
	public void closeRes() throws SQLException;
	
}
