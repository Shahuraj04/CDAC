package com.organization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.dto.DepartmentDTO;
import com.organization.dto.DeptUpdationDTO;
import com.organization.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;

	@PostMapping("/newdepartment")
	public ResponseEntity<?> newDept(@RequestBody @Valid DepartmentDTO departmentDTO) {

		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDept(departmentDTO));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateDetails(@RequestBody @Valid DeptUpdationDTO deptUpdationDTO){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentService.updateDepartment(deptUpdationDTO));
		

	}

}
