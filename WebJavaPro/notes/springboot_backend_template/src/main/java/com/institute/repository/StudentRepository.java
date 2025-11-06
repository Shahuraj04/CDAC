package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institute.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	
	boolean existsByEmail(String email);
	
	

}
