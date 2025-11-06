package com.institute.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dto.ApiResponse;
import com.institute.dto.StudentDTO;
import com.institute.entities.Student;
import com.institute.exception.ResourceAlreadyExistException;
import com.institute.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private  final StudentRepository studentRepository;
	private ModelMapper mapper;

	@Override
	public ApiResponse addStudent(StudentDTO dto) {
		
		if(studentRepository.existsByEmail(dto.getEmail())) {
			throw new ResourceAlreadyExistException("Student with same already exist");
		}
		Student student = mapper.map(dto, Student.class);
		studentRepository.save(student);
		
		ApiResponse apiResponse = new ApiResponse("created", "creaated");
		return apiResponse;
	}
	
	
	
}
