package com.flight.dao;

import static com.flight.utils.DBUtils.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flight.pojo.Destination;
import com.flight.pojo.Flight;
import com.flight.pojo.Source;

public class FlightDaoImpl implements FlightDao {
	private Connection cn;
	private PreparedStatement pst1;

	public FlightDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from flights where source=? and destination=? and departure_date=?");
	}

	@Override
	public List<Flight> showList(String src, String dest, Date date) throws SQLException {
		pst1.setString(1, src);
		pst1.setString(2, dest);
		pst1.setDate(3, date);
		List<Flight> list = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {

				list.add(new Flight(Source.valueOf(rst.getString(3)), Destination.valueOf(rst.getString(4)),
						rst.getDate(5)));
			}

		}

		return list;

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
