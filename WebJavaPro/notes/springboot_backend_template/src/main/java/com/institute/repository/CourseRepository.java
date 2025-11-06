package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institute.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> { 
	
	boolean existsByName(String name);

}
