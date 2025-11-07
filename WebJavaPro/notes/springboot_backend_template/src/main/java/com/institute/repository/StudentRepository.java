package com.institute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institute.entities.Course;
import com.institute.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	
	boolean existsByEmail(String email);
	
	
	

}
