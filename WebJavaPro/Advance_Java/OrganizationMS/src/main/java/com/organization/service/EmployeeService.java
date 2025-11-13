package com.organization.service;

import java.util.List;

import com.organization.dto.ApiResponse;
import com.organization.dto.EmployeeDTO;
import com.organization.entities.Employee;

public interface EmployeeService {

	ApiResponse addEmployee(EmployeeDTO employeeDTO);

	List<Employee> getAllbyname(String deptname);

}
