package com.institute.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institute.dto.ApiResponse;
import com.institute.dto.CourseDto;
import com.institute.dto.CourseUpdateDto;
import com.institute.entities.Category;
import com.institute.entities.Course;
import com.institute.entities.Student;
import com.institute.exception.ResourceAlreadyExistException;
import com.institute.exception.ResourceNotFoundException;
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

		if (courseRepository.existsByName(courseDto.getName())) {
			throw new ResourceAlreadyExistException("Course with same name already exist");

		}

		Course c = new Course(courseDto.getName(), courseDto.getCategory(), courseDto.getStartDate(),
				courseDto.getEndDate(), courseDto.getFees(), courseDto.getRequiredMarks());
		courseRepository.save(c);
		ApiResponse apiResponse = new ApiResponse("Created", "created");
		return apiResponse;
	}

	@Override
	public CourseDto updateCourseDetails(CourseUpdateDto courseUpdateDto, Long courseId) {

		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("course not found with id " + courseId));
		course.setStartDate(courseUpdateDto.getStartDate());
		course.setEndDate(courseUpdateDto.getEndDate());
		course.setFees(courseUpdateDto.getFees());

		CourseDto courseDto = mapper.map(course, CourseDto.class);
		courseRepository.save(course);

		return courseDto;
	}

	@Override
	public List<CourseDto> getAllByCategory(Category category) {
	    List<Course> courses = courseRepository.findByCategory(category);

	    if (courses.isEmpty()) {
	        throw new ResourceNotFoundException("No courses found for category: " + category);
	    }
	    List<CourseDto>courseDtos = courses.stream()
        .map(course -> mapper.map(course, CourseDto.class))
        .toList();
	    
	    return courseDtos;
	}

	@Override
	public List<Student> getAllByCourse(Category valueOf) {
		courseRepository.g
		return null;
	}


}
