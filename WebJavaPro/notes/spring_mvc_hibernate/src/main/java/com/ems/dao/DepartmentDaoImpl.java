package com.ems.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entities.Department;

@Repository // mandatory class level annotation to declare DAO layer spring bean

public class DepartmentDaoImpl implements DepartmentDao {
	// dependency of dao layer is -SessionFactory
	@Autowired // by type
	private SessionFactory sessionFactory;

	@Override
	public List<Department> getAllDepartments() {
		String jpql = "Select d from Department d";

		return sessionFactory.getCurrentSession().createQuery(jpql, Department.class).getResultList();
	}

}
