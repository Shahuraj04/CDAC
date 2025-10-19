package com.flight.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.flight.pojo.Customer;
import com.flight.pojo.Reservation;

public interface ReservationDao {

		Reservation reserveSeat(Date rdate,String pEmail,String pFname,String pLname,String Phno,int flight_id) throws SQLException;
		Customer getData(String email) throws SQLException;
}
