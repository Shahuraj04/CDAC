package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public String registerDoctor(Doctor doctor) {
		String mesg = "Registering Doctor failed....";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			
			session.persist(doctor);
			doctor.getUserDetails().getId();
			
			
			tx.commit();
			mesg = "Doctor registered with ID " + doctor.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public Doctor getDoctorDetails(Long userId) {
		Doctor doctor = null;
		// 1. Get Session from SessionFactory
		String jpql = "select d from Doctor d  where d.userDetails.id=:uid";
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			doctor = session.createQuery(jpql, Doctor.class).setParameter("uid", userId).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return doctor;
	}

}
