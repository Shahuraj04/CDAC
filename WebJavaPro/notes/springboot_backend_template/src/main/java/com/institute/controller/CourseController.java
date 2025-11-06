package com.institute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.dto.CourseDto;
import com.institute.service.CourseService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/course")
@AllArgsConstructor

public class CourseController {

	private CourseService courseService;

	@PostMapping("/newcourse")
	public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto ){
		try {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courseDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(courseService.addCourse(courseDto));
					}
		
	}

}
