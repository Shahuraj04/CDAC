package com.demo.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.demo.dao.Doctordao;
import com.demo.dao.DoctordaoImpl;
import com.demo.pojos.Patient;

public class PatientTester {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		Doctordao doc = new DoctordaoImpl();
		Patient p = doc.patientsignin("neha.gupta@example.in", "pass456");
		if (p != null) {
            System.out.println("\n Login successful!");
            System.out.println("Patient details:");
            System.out.println(p);
        } else {
            System.out.println("\n Invalid email or password!");
        }
		
		
	}

}
