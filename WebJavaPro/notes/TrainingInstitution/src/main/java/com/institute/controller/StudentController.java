package com.institute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.institute.dto.StudentDTO;
import com.institute.service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor

public class StudentController {

	private final StudentService studentService;

	@PostMapping("/register")
	public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO studentDTO) {

		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentDTO));

	}
	
	
	
	@DeleteMapping("/deletestudent")
	public ResponseEntity<?> deleteStudent(@RequestParam Long studentId ){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.deleteStudentById(studentId));
		

		
	}
	@GetMapping("/bycourse")
	public ResponseEntity<?> getAllbyCourse(@RequestParam String courseName){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.findByCourseName(courseName));
	}
	

}
