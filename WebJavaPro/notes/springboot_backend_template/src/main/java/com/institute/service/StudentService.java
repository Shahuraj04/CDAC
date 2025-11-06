package com.institute.service;

import com.institute.dto.ApiResponse;
import com.institute.dto.StudentDTO;

public interface StudentService {
	
	ApiResponse addStudent(StudentDTO dto);

}
