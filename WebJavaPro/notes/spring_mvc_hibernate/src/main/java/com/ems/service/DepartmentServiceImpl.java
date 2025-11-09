package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.DepartmentDao;
import com.ems.entities.Department;

@Service // mandatory class level annotation to declare bean having BL
@Transactional // mandatory annotaion for auto tx management
public class DepartmentServiceImpl implements DepartmentService {
// dependancy -dao layer i/f
	@Autowired // by type
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments() {
		//invokes dao's method
		return departmentDao.getAllDepartments();
	}

}
