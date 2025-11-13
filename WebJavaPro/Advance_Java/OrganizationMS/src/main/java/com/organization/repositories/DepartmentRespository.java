package com.organization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.entities.Department;

public interface DepartmentRespository extends JpaRepository<Department, Long> {

	
	boolean existsBydeptName(String name);
}
