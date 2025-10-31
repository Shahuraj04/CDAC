package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public String bookAppointment(Long doctorId, Long patientId, LocalDateTime ts) {
		String mesg = "Appointment unavailable, please choose another Date/Time";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			boolean doctorAvailable = isDoctorAvailable(session, doctorId, ts);

			if (doctorAvailable) {
				Appointment appointment = new Appointment();
				appointment.setMyDoctor(session.find(Doctor.class, doctorId));
				appointment.setMyPatient(session.find(Patient.class, patientId));
				appointment.setAppointmentDateTime(ts);
				appointment.setStatus(Status.SCHEDULED);

				session.persist(appointment);
				mesg = "Appointment booked successfully!";
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	private boolean isDoctorAvailable(Session session, Long docId, LocalDateTime ts) {
		String jpql = "select a from Appointment a where a.myDoctor.id = :id and a.appointmentDateTime > :Time and a.appointmentDateTime < :plusTime";
		List<Appointment> appointments = session.createQuery(jpql, Appointment.class).setParameter("id", docId)
				.setParameter("Time", ts).setParameter("plusTime", ts.plusMinutes(30)).getResultList();

		return appointments.isEmpty();
	}

	@Override
	public String cancelAppointment(Long appointmentId, Long patientId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

	@Override
	public List<AppointmentDTO> listUpcomingAppointmentsForPatient(Long patientId) {
		List<AppointmentDTO> list = null;
		Session session = getFactory().getCurrentSession();
		String jpql = "SELECT new com.healthcare.dto.AppointmentDTO(a.id, a.appointmentDateTime, "
				+ "a.myDoctor.userDetails.firstName, a.myDoctor.userDetails.lastName) "
				+ "FROM Appointment a WHERE a.myPatient.id = :id AND a.status = :sts";
		Transaction tx = session.beginTransaction();

		try {
			list = session.createQuery(jpql, AppointmentDTO.class).setParameter("id", patientId)
					.setParameter("sts", Status.SCHEDULED).getResultList();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return list;
	}

	@Override
	public List<AppointmentDTO> listUpcomingAppointmentsForDoctor(Long doctorId) {
		// TODO: implement
		return null;
	}
}
