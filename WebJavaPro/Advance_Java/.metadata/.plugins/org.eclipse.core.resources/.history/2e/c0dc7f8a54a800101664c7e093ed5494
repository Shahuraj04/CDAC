package com.db.tester;

import static com.db.util.DBUtils.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class gettingData {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try (Connection cn = openConnection();
				Statement st = cn.createStatement();
				ResultSet rst = st.executeQuery("select * from data")) {
		while(rst.next()) {
			System.out.printf("Id %d Name %s Dob %s %n",rst.getInt(1),rst.getString(2),rst.getString(3));
		}
		}

	}
}
