package com.organization.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.dto.ApiResponse;
import com.organization.dto.EmployeeDTO;
import com.organization.entities.Employee;
import com.organization.exceptions.ResourceAlreadyExistException;
import com.organization.repositories.DepartmentRespository;
import com.organization.repositories.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.Setter;
@Service
@Transactional
@Setter
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	
	private final EmployeeRepository employeeRepository;
	private final DepartmentRespository departmentRespository;
	private final ModelMapper mapper;
	
	@Override
	public ApiResponse addEmployee(EmployeeDTO employeeDTO) {
		if(!employeeRepository.existsByEmail(employeeDTO.getEmail())) {
			Employee employee= mapper.map(employeeDTO, Employee.class);
			employee.setDepartment(departmentRespository.findById(employeeDTO.getDepartment()).orElseThrow(()->new ResourceAlreadyExistException("not found")));
			
			employeeRepository.save(employee);
			return new ApiResponse("Created Empl", "CREATED");
		}
		
		else {
			throw new ResourceAlreadyExistException("EMail already exist!!");
		}
	}

	@Override
	public List<Employee> getAllbyname(String deptname) {
		
		List<Employee> list = employeeRepository.findAllByDepartmentDeptName(deptname);
//		List<EmployeeDTO> list2= list.stream().map(lists->mapper.map(lists, EmployeeDTO.class)).toList();
		return list;
	}

}
