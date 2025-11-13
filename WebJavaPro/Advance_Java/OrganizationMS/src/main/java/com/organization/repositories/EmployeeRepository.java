package com.organization.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	boolean existsByEmail(String email);
	
	List<Employee> findAllByDepartmentDeptName(String name);
}
