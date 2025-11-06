package com.institute.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.dto.StudentDTO;
import com.institute.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor

public class StudentController {

	private final  StudentService studentService;
	
	@PostMapping("register")
	public ResponseEntity<?> registerStudent(@RequestBody StudentDTO studentDTO){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentDTO));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(studentService.addStudent(studentDTO));
					}
		
		
	}

	
	
}
