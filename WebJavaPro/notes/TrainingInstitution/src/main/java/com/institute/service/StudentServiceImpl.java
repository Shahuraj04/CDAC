package com.institute.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dto.ApiResponse;
import com.institute.dto.StudentDTO;
import com.institute.entities.Course;
import com.institute.entities.Student;
import com.institute.exception.ResourceAlreadyExistException;
import com.institute.exception.ResourceNotFoundException;
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
		Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + dto.getCourseId()));
		Student student = mapper.map(dto, Student.class);
		student.setCourse(course);
		studentRepository.save(student);
		ApiResponse apiResponse = new ApiResponse("created", "creaated");
		return apiResponse;
	}

	@Override
	public ApiResponse deleteStudentById(Long studentId) {
		
		Student student = studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("student with id "+studentId+" not found!!"));
		studentRepository.delete(student);
		
		ApiResponse apiResponse = new ApiResponse("Student Deleted", "deleted");
		return  apiResponse;
	}

	@Override
	public List<StudentDTO> findByCourseName(String name) {
	    List<Student> students = studentRepository.findByCourse_Name(name);
	    
	    List<StudentDTO> dtoList = students.stream()
	            .map(student -> mapper.map(student, StudentDTO.class))
	            .toList(); // Java 16+ (or use collectors if older)
	    
	    return dtoList;
	}


//	@Override
//	public List<Student> getAllByCourse(String courseName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
	
	
}
