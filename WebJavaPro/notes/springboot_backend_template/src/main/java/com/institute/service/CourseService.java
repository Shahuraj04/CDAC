package com.institute.service;

import com.institute.dto.ApiResponse;
import com.institute.dto.CourseDto;

public interface CourseService {
	ApiResponse addCourse(CourseDto courseDto);

}
