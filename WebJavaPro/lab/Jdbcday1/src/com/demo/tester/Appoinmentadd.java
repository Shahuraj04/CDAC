package com.demo.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.demo.dao.Doctordao;
import com.demo.dao.DoctordaoImpl;

public class Appoinmentadd {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		
		Doctordao dr = new DoctordaoImpl();
		System.out.println(dr.addappointment(1, 2, "2025-02-02"));

	}

}
