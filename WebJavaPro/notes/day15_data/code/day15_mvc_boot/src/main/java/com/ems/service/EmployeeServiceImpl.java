package com.ems.service;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ems.controller.HelloController;
import com.ems.dao.EmployeeDao;
import com.ems.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private final HelloController helloController;
	// depcy
	@Autowired
	private EmployeeDao employeeDao;

	EmployeeServiceImpl(HelloController helloController) {
		this.helloController = helloController;
	}

	@Override
	public List<Employee> getEmpsByDeptId(Long deptId) {
		// TODO Auto-generated method stub
		return employeeDao.findByMyDepartmentId(deptId);
	}

	@Override
	public String deleteEmpById(Long empid) {

		if (employeeDao.existsById(empid)) {
			employeeDao.deleteById(empid);
			return "Available";
		} else {
			return "Not found";
		}
	}

}
