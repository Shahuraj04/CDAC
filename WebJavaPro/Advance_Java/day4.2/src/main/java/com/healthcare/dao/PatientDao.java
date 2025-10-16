package com.healthcare.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthcare.pojos.Appointments;
import com.healthcare.pojos.Patient;

public interface PatientDao {
	Patient signIn(String email, String password) throws SQLException;
	List<Appointments> showAllAppointments(int id) throws SQLException;
	public String addAppointment(int doc_id,int p_id,String date) throws SQLException;
	String deleteAppointment(int id) throws SQLException; 
	void cleanUp() throws SQLException;

}
