package com.demo.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.demo.dao.Doctordao;
import com.demo.dao.DoctordaoImpl;

public class DeleteTester {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		Doctordao d = new DoctordaoImpl();
		System.out.println("Enter the id of patient to remove");
		System.out.println(d.deletepatient(sc.next()));

	}

}
