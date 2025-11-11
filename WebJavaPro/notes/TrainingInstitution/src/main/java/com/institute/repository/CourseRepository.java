package com.institute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institute.entities.Category;
import com.institute.entities.Course;
import com.institute.entities.Student;

public interface CourseRepository extends JpaRepository<Course, Long> { 
	
	boolean existsByName(String name);
	List<Course> findByCategory(Category category);
	List<Course> findByName(String name);
}
