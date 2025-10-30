package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;

public class BookingTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AppointmentDao appointmentDao = new AppointmentDaoImpl();
			Long id = Long.parseLong("1");
			Long id2 = Long.parseLong("1");
			System.out.println(appointmentDao.bookAppointment(id, id2, LocalDateTime.parse("2025-10-30T17:58")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
