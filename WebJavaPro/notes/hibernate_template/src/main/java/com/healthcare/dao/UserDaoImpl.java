package com.healthcare.dao;

import com.healthcare.entities.User;
import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User newUser) {
		// 1.Get Session from sessionfactory
		Session session = getFactory().getCurrentSession();
		// 2.Begin a TransacTion
		Transaction tx = session.beginTransaction();
		try {
			//3.Session API for inserting a record
			session.persist(newUser);
			tx.commit();
			
		} catch (RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
		}
		return "user registered successfully  "+newUser.getId();
	}

}
