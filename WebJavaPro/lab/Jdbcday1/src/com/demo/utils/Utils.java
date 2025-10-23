package com.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	
	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/iacsd_25";
	private static String user="root";
	private static String pswd="root123";
	
	public static Connection openconnection() throws SQLException{
		connection=DriverManager.getConnection(url, user, pswd);
		return connection;
	}
	
	public static void closeconnectio()throws SQLException{
		if(connection!= null)
			connection.close();
	}
}
