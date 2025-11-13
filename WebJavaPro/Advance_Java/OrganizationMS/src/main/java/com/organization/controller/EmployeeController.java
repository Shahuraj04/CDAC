package com.organization.controller;

import java.net.ResponseCache;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.EmployeeDTO;
import com.organization.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@PostMapping("/addnew")
	public ResponseEntity<?> addEmpl(@RequestBody @Valid EmployeeDTO employeeDTO ){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeDTO));
	}
	
	@GetMapping("/getallbyname")
	public ResponseEntity<?> getAllbyDeptName(@RequestParam String deptname){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.getAllbyname(deptname));
	}
	
}
