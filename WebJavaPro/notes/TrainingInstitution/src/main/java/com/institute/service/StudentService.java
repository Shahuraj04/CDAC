package com.institute.service;

import java.util.List;

import com.institute.dto.ApiResponse;
import com.institute.dto.StudentDTO;
import com.institute.entities.Category;
import com.institute.entities.Student;

public interface StudentService {
	
	ApiResponse addStudent(StudentDTO dto);

	ApiResponse deleteStudentById(Long studentId);
	List<StudentDTO> findByCourseName(String name);

	//List<Student> getAllByCourse(String courseName);

	
}
