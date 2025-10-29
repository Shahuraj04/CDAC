package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.dao.UserDao;
import com.healthcare.dao.UserDaoImpl;
import com.healthcare.entities.Appointment;

public class LoginTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create user dao instance
			AppointmentDao userDao = new AppointmentDaoImpl();
			System.out.println("Enter Email: ");
			String em = sc.next();
			System.out.println("Enter password: ");
			String pswd = sc.next();
			System.out.println(userDao.bookAppointment(null, null, null));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
