package com.institute.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dto.ApiResponse;
import com.institute.dto.StudentDTO;
import com.institute.entities.Category;
import com.institute.entities.Course;
import com.institute.entities.Student;
import com.institute.exception.ResourceAlreadyExistException;
import com.institute.repository.CourseRepository;
import com.institute.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private  final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private ModelMapper mapper;

	@Override
	public ApiResponse addStudent(StudentDTO dto) {
		
		if(studentRepository.existsByEmail(dto.getEmail())) {
			throw new ResourceAlreadyExistException("Student with same already exist");
		}
		Course course = courseRepository.findById(dto.getCourse())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourse()));
		Student student = mapper.map(dto, Student.class);
		student.setCourse(course);
		studentRepository.save(student);
		ApiResponse apiResponse = new ApiResponse("created", "creaated");
		return apiResponse;
	}

	
	
	
	
}
