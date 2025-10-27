package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

public class HibernateTester {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory()) {
			System.out.println("Hibernate Running "+factory);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
