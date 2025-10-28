package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.closeConnection;
import static com.healthcare.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.pojos.Appointments;
import com.healthcare.pojos.Patient;

public class PatientDaoImpl implements PatientDao {
	// state
	private Connection cn;
	private PreparedStatement pst1,pst2,cs1;
	

	public PatientDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// create pst1 - logi
//		+----+-----------+------------+----------------------+-----------+-------------------+
//		| id | doctor_id | patient_id | appointment_datetime | status    | name              |1
		pst1 = cn.prepareStatement("select * from patients where email=? and password=?");
		pst2= cn.prepareStatement("select a.*,d.name  from  Appointments a join Doctors d on a.doctor_id = d.id where patient_id=?");
		System.out.println("patient dao created");
		cs1 = cn.prepareCall("{call addAppointment(?,?,?)}");
		
	}

	@Override
	public Patient signIn(String email, String password) throws SQLException {
	
		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery()) {
			
			if (rst.next()) {
				return new Patient(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(5), rst.getDate(6));
			}
		}
		return null;
	}
	@Override
	public List showAllAppointments(int id) throws SQLException {
		pst2.setInt(1, id);
//		+----+-----------+------------+----------------------+-----------+-------------------+
//		| id | doctor_id | patient_id | appointment_datetime | status    | name              |1

		List<Appointments> list  = new ArrayList<>();
		ResultSet rst = pst2.executeQuery();
			while(rst.next()) {
				java.sql.Timestamp ts = rst.getTimestamp(4); 
				 LocalDateTime date=ts.toLocalDateTime();
				list.add(new Appointments(rst.getInt(1), rst.getInt(2),rst.getInt(3),date, "SCHEDULED",rst.getString(6)));
			}
			
		
		return list;
	}
	@Override
	public String addAppointment(int doc_id, int p_id, String date) throws SQLException {
		
		cs1.setInt(1, doc_id);
		cs1.setInt(2, p_id);

		java.sql.Date d1 = java.sql.Date.valueOf(date);
		cs1.setDate(3, d1);

		int rows = cs1.executeUpdate();

		if (rows > 0)
			return "Appointment added successfully!";
		else
			return "Failed to add appointment.";
	}
	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		closeConnection();
		System.out.println("patient dao cleaned up");

	}

	

	

}
