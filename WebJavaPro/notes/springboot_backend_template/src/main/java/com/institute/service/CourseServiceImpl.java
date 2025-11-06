package com.institute.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dto.ApiResponse;
import com.institute.dto.CourseDto;
import com.institute.entities.Course;
import com.institute.exception.ResourceAlreadyExistException;
import com.institute.repository.CourseRepository;

import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository; 
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addCourse(CourseDto courseDto) {
		
		if(courseRepository.existsByName(courseDto.getName())) {
			throw new ResourceAlreadyExistException("Course with same name already exist");
			
		}
		
		Course c= new Course(courseDto.getName(), courseDto.getCategory(), courseDto.getStartDate(),courseDto.getEndDate(),courseDto.getFees(),courseDto.getRequiredMarks());
		courseRepository.save(c);
		ApiResponse apiResponse = new ApiResponse("Created","created");
		return apiResponse;
	}

}
