package com.organization.service;

import com.organization.dto.ApiResponse;
import com.organization.dto.DepartmentDTO;
import com.organization.dto.DeptUpdationDTO;

import jakarta.validation.Valid;

public interface DepartmentService {

	ApiResponse addDept(DepartmentDTO departmentDTO);

	DeptUpdationDTO updateDepartment(DeptUpdationDTO deptUpdationDTO);

}
