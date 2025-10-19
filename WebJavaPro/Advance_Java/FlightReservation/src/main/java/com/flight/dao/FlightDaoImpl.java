package com.flight.dao;

import static com.flight.utils.DBUtils.closeConnection;
import static com.flight.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flight.pojo.Airline;
import com.flight.pojo.Destination;
import com.flight.pojo.Flight;
import com.flight.pojo.Source;

public class FlightDaoImpl implements FlightDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;

	public FlightDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from flights where source=? and destination=? and departure_date=?");
		pst2= cn.prepareStatement("select * from flights where flight_id=?");
		pst3=cn.prepareStatement("select * from customers where email=? and password=?");
	}

	@Override
	public List<Flight> showList(String src, String dest, Date date) throws SQLException {
		pst1.setString(1, src);
		pst1.setString(2, dest);
		pst1.setDate(3, date);
		List<Flight> list = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {

				list.add(new Flight(rst.getInt(1), Airline.valueOf(rst.getString(2).toUpperCase()),
						Source.valueOf(rst.getString(3).toUpperCase()),
						Destination.valueOf(rst.getString(4).toUpperCase()), rst.getDate(5), rst.getTimestamp(7),
						rst.getDouble(10)));
			}

		}
		return list;
	}

	@Override
	public Flight selectedFlight(int flight_id) throws SQLException {
		pst2.setInt(1, flight_id);
		try(ResultSet rst = pst2.executeQuery()){
				while(rst.next()) {
					return new Flight(rst.getInt(1), Airline.valueOf(rst.getString(2).toUpperCase()),
						Source.valueOf(rst.getString(3).toUpperCase()),
						Destination.valueOf(rst.getString(4).toUpperCase()), rst.getDate(5), rst.getTimestamp(7),
						rst.getDouble(10));
				}
			
		}
		return null;
	}
	
	@Override
	public boolean validateCustomer(String email, String pswd) throws SQLException {
		pst3.setString(1, email);
		pst3.setString(2, pswd);
		try(ResultSet rst = pst3.executeQuery()){
			while(rst.next()) {
				return true;
			}
		}
		return false;
	}

		
	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		if (pst2 != null) {
			pst2.close();
			pst2 = null;
		}
		closeConnection();
		System.out.println("patient dao cleaned up");

	}

	
	

}
