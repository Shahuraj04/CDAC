package com.demo.dao;

import static com.demo.utils.Utils.openconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.pojos.Patient;

public class DoctordaoImpl implements Doctordao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;
	private CallableStatement cs1;

	public DoctordaoImpl() throws SQLException {
		cn = openconnection();
		pst1 = cn.prepareStatement("select * from patients where email=? and password=?");
		pst2 = cn.prepareStatement("select * from patients where dob between ? and ?");
		pst3 = cn.prepareStatement("Delete from patients where email = ?");
		cs1=cn.prepareCall("{call addAppointment(?,?,?)}");
		
		
	}

	@Override
	public Patient patientsignin(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);

		// | id | name | email | password | phone | dob |
		try (ResultSet rs = pst1.executeQuery()) {
			while (rs.next()) {
				return new Patient(rs.getString("name"), rs.getString("email"), rs.getString("password"),
						rs.getString("phone"), rs.getDate("dob"));
			}
			return null;
		}
	}

	@Override
	public List<Patient> displaybyDate(String startDate, String endDate) throws SQLException {
		List<Patient> list = new ArrayList<>();
		Date d1 = Date.valueOf(startDate);
		Date d2 = Date.valueOf(endDate);
		pst2.setDate(1, d1);
		pst2.setDate(2, d2);

		// | id | name | email | password | phone | dob |
		try (ResultSet rs1 = pst2.executeQuery()) {
			while (rs1.next()) {
				list.add(new Patient(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getDate(6)));

			}
		}

		return list;
	}

	@Override
	public String addappointment(int doc_id, int pat_id, String date) throws SQLException {
		cs1.setInt(1, doc_id);
		cs1.setInt(2, pat_id);
		Date d1 = Date.valueOf(date);
		cs1.setDate(3, d1);
		if(cs1.execute()) {
			return "appoitment added";
		}
		return "Appointment not added";
	}

	@Override
	public String deletepatient(String email) throws SQLException {
		pst3.setString(1, email);
		if (pst3.executeUpdate() == 1)
			return "user removed";
		return "new user found!!!! ";
	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
	}

}
