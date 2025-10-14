package com.health.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.health.dao.HealthDao;
import com.health.dao.HealthDaoImpl;

public class DeleteTester {

	public static void main(String[] args) throws SQLException {
		try(Scanner sc = new Scanner(System.in)){
			
			HealthDao dr = new HealthDaoImpl();

			System.out.println("Enter id to delete patient: ");
			System.out.println(dr.deleltePatient(sc.nextInt()));
			
		}

	}

}
