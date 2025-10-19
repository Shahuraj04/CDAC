package com.flight.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.flight.pojo.Flight;

public interface FlightDao {
	List<Flight> showList(String src,String dest,Date date) throws SQLException;
	Flight selectedFlight(int flight_id) throws SQLException; 
	boolean validateCustomer(String email,String pswd) throws SQLException;
	void cleanUp() throws SQLException;
}
