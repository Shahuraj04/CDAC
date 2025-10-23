package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.pojos.Patient;

public interface Doctordao {
	
	
	public Patient patientsignin(String email,String password) throws SQLException;
	public List<Patient> displaybyDate(String startDate,String endDate) throws SQLException;
	public String deletepatient(String s) throws SQLException;
	public String addappointment(int doc_id,int pat_id,String date) throws SQLException;
	void cleanUp() throws SQLException; 

}
