package com.health.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.health.dao.HealthDao;
import com.health.dao.HealthDaoImpl;

public class DateTester {

	public static void main(String[] args) throws SQLException {
		try (Scanner sc = new Scanner(System.in)) {
			HealthDao dr = new HealthDaoImpl();
			System.out.println("Enter Starting date: ");
			String d1 = sc.next();
			System.out.println("Enter Ending date: ");
			String d2 = sc.next();
			dr.displayByDob(d1, d2).forEach(System.out::println);

		}

	}
}
