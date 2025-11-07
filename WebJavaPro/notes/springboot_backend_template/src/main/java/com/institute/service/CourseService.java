package com.institute.service;

import java.util.List;

import com.institute.dto.ApiResponse;
import com.institute.dto.CourseDto;
import com.institute.dto.CourseUpdateDto;
import com.institute.entities.Category;
import com.institute.entities.Student;

public interface CourseService {
	ApiResponse addCourse(CourseDto courseDto);

	CourseDto updateCourseDetails(CourseUpdateDto courseUpdateDto, Long courseId);

	List<CourseDto> getAllByCategory(Category category);

	List<Student> getAllByCourse(Category valueOf);

}
