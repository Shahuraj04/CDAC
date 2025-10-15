package com.healtcare.doa;

import static com.healthcare.utils.DbUtils.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.pojo.Patient;

public class HealthDaoImpl implements HealthDao {

	private Connection cn;
	private PreparedStatement ps1, ps2, ps3, cs1;

	public HealthDaoImpl() throws SQLException {
		cn = openConnection();
		ps1 = cn.prepareStatement("select * from patients where email=? and password=?");
		ps2 = cn.prepareStatement("select * from patients where dob between ? and ?");
		ps3 = cn.prepareStatement("delete from patients where id=?");
		cs1 = cn.prepareCall("{call addAppointment(?,?,?)}");

	}

	@Override
	public Patient PatientSignIn(String email, String pswd) throws SQLException {
		ps1.setString(1, email);
		ps1.setString(2, pswd);
		try (ResultSet rs = ps1.executeQuery()) {
			if (rs.next()) {
//			| id | name          | email                    | password | phone      | dob        |
				return new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6));

			}
		}

		return null;
	}

	@Override
	public List<Patient> displayByDob(String startDate, String endDate) throws SQLException {
		Date d1 = Date.valueOf(startDate);
		Date d2 = Date.valueOf(endDate);
		List<Patient> list = new ArrayList<>();

		ps2.setDate(1, d1);
		ps2.setDate(2, d2);
		try (ResultSet rs = ps2.executeQuery()) {
			while (rs.next()) {
//	| id | name| email| password | phone| dob|
				list.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6)));
			}
		}
		return list;
	}

	@Override
	public String deleltePatient(int id) throws SQLException {
//		| id | name | email | password | phone | dob |

		ps3.setInt(1, id);
		if (ps3.executeUpdate() > 0) {
			return "Patient Deleted";
		}

		return "Patient not found with given id!!";
	}

	@Override
	public String addAppointment(int doc_id, int p_id, String date) throws SQLException {

		cs1.setInt(1, doc_id);
		cs1.setInt(2, p_id);

		java.sql.Timestamp d1 = java.sql.Timestamp.valueOf(date);
		cs1.setTimestamp(3, d1);

		int rows = cs1.executeUpdate();

		if (rows > 0)
			return "Appointment added successfully!";
		else
			return "Failed to add appointment.";
	}

	@Override
	public void closeRes() throws SQLException {
		if (ps1 != null) {
			ps1.close();
		}
		if (ps2 != null) {
			ps2.close();
		}
		if (ps3 != null) {
			ps3.close();
		}
		if (cs1 != null) {
			cs1.close();
		}
		if (cn != null) {
			cn.close();
		}

	}

}
