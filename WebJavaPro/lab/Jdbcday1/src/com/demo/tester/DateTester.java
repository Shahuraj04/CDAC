package com.demo.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.demo.dao.Doctordao;
import com.demo.dao.DoctordaoImpl;

public class DateTester {
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		Doctordao dr = new DoctordaoImpl();
		System.out.println("Enter starting date: ");
		String d1=sc.nextLine();
		
		System.out.println("Enter Ending date: ");
		String d2=sc.nextLine();
		
		dr.displaybyDate(d1, d2)
		.forEach(System.out::println);
		
		
		
	}

}
