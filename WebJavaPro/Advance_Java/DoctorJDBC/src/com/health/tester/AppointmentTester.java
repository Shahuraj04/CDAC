package com.health.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.health.dao.HealthDaoImpl;

public class AppointmentTester {

	public static void main(String[] args) throws SQLException {
		try(Scanner sc = new Scanner(System.in)){
			
			HealthDaoImpl dr=new  HealthDaoImpl();
			System.out.println("Enter Doctor id: ");
			int did=sc.nextInt();
			System.out.println("Enter Patient Id: ");
			int pid = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter appointment date(yyyy-mm-dd hh:mm:ss): ");
			String  dt= sc.nextLine();
			System.out.println(dr.addAppointment(did, pid, dt));
			
			
			
		}

	}

}
