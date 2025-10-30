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
	public String bookAppointment(LocalDateTime dateTime, Long doc_id, Long pat_id) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Doctor doc = session.find(Doctor.class, doc_id);
			Patient pat = session.find(Patient.class, pat_id);

			if (doc == null || pat == null) {
				return "Invalid doctor or patient ID!";
			}

			Appointment appointment = new Appointment(dateTime); // constructor created using @RequiredArgsConstructor
			appointment.setStatus(Status.SCHEDULED);
			appointment.setMyDoctor(doc);
			appointment.setMyPatient(pat);

			session.persist(appointment);
			tx.commit(); // ✅ commit the transaction

			return "Appointment booked successfully with ID: " + appointment.getId();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	}

}
