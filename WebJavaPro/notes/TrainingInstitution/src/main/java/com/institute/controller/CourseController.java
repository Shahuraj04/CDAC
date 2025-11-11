package com.institute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.institute.dto.ApiResponse;
import com.institute.dto.CourseDto;
import com.institute.dto.CourseUpdateDto;
import com.institute.entities.Category;
import com.institute.service.CourseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/course")
@AllArgsConstructor

public class CourseController {

	private CourseService courseService;

	@PostMapping("/newcourse")
	public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courseDto));

	}

	@PutMapping("/{courseId}/update")
	public ResponseEntity<?> updateCourseDetails(@PathVariable Long courseId,
			@RequestBody @Valid CourseUpdateDto courseUpdateDto) {

		return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourseDetails(courseUpdateDto, courseId));

	}

	@GetMapping("/allcourses")
	public ResponseEntity<?> getAllByCategory(@RequestParam String category) {

		Category catEnum;
		try {
			catEnum = Category.valueOf(category.toUpperCase());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body("Invalid category. Available categories: JAVA, DBT, ...");
		}

		return ResponseEntity.ok(courseService.getAllByCategory(catEnum));

	}

	@DeleteMapping("/deletecourse{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
		
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseService.deleteCourse(courseId));
	}
	
}
