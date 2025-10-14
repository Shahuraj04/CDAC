package com.health.tester;

import java.util.Scanner;

import com.health.dao.HealthDao;
import com.health.dao.HealthDaoImpl;
import com.health.pojo.Patient;

public class PatientSignIn {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			HealthDao dr =new HealthDaoImpl();
			
			System.out.println("Enter Email:");
			String mail = sc.next();
			System.out.println("Enter password: ");
			String pswd = sc.next();
			Patient p= dr.PatientSignIn(mail, pswd);
			
			if(p!=null) {
				System.out.println("Login Successull");
				System.out.println(p);
			}
			if(p==null) {
				System.out.println("Invalid Email/Password");
			}
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		
	}

}
