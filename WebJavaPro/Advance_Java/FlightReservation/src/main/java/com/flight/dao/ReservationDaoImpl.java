package com.flight.dao;

import static com.flight.utils.DBUtils.openConnection;

import java.awt.RadialGradientPaint;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flight.pojo.Customer;
import com.flight.pojo.Reservation;
import static com.flight.utils.DBUtils.*;

public class ReservationDaoImpl implements ReservationDao {
	
	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	 public ReservationDaoImpl() throws SQLException {

		cn = openConnection();
		pst1 = cn.prepareStatement("insert into reservations(reservation_date,email,first_name,last_name,phone_no ,status ,flight_id ) values(?,?,?,?,?,?,?)");
		pst2= cn.prepareStatement("select * from customers where email=?");
	}

	@Override
	public Reservation reserveSeat(Date rdate, String pEmail, String pFname, String pLname, String Phno,
			int flight_id) throws SQLException {
		pst1.setDate(1, rdate);
		pst1.setString(2, pEmail);
		pst1.setString(3, pFname);
		pst1.setString(4, pLname);
		pst1.setString(5, Phno);
		pst1.setString(6, "Booked");
		pst1.setInt(7, flight_id);
		int i = pst1.executeUpdate();
		if(i>0) {
			return new Reservation(rdate, pEmail, pFname, pLname, Phno, "Booked", flight_id);
		}
		return null;
		
		
		
	}

	@Override
	public Customer getData(String email) throws SQLException {
		pst2.setString(1,email);
		try(ResultSet rst=pst2.executeQuery()){
			while(rst.next()) {
				return new Customer(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDate(6),rst.getInt(7));
			}
		}
		return null;
	}

}
