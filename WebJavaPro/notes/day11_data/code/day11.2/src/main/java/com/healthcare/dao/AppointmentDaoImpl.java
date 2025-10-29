package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;
import com.healthcare.entities.User;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public String bookAppointment(LocalDateTime dateTime, Long  doc_id, Long pat_id) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Appointment appointment = new Appointment();
		appointment.setAppointmentDateTime(LocalDateTime.now());
		appointment.setStatus(Status.SCHEDULED);
		appointment.setMyDoctor(session.find(Doctor.class, 1));
		appointment.setMyPatient(session.find(Patient.class, 3));
		
		try {
			session.persist(appointment);
			
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}
		return null;
	}

}
