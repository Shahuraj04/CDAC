package com.organization.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.dto.ApiResponse;
import com.organization.dto.DepartmentDTO;
import com.organization.dto.DeptUpdationDTO;
import com.organization.entities.Department;
import com.organization.exceptions.ResourceAlreadyExistException;
import com.organization.repositories.DepartmentRespository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRespository departmentRespository;
	private ModelMapper mapper;

	@Override
	public ApiResponse addDept(DepartmentDTO departmentDTO) {
		if (!departmentRespository.existsBydeptName(departmentDTO.getDeptName())) {
			Department department = mapper.map(departmentDTO, Department.class);
			departmentRespository.save(department);
			return new ApiResponse("Deparatment created with name " + departmentDTO.getDeptName(), "CREATED");

		}

		else {
			throw new ResourceAlreadyExistException("Department ALready exist");
		}
	}

	@Override
	public DeptUpdationDTO updateDepartment(DeptUpdationDTO deptUpdationDTO) {

		Department department = departmentRespository.findById(deptUpdationDTO.getDeptId())
				.orElseThrow(() -> new ResourceAlreadyExistException("Department doesnt exist"));
		department.setDeptName(deptUpdationDTO.getDeptName());
		department.setLocation(deptUpdationDTO.getLocation());
		department.setManagerName(deptUpdationDTO.getManagerName());
		department.setBudget(deptUpdationDTO.getBudget());
		
		
		
		departmentRespository.save(department);

		return mapper.map(department,DeptUpdationDTO.class);
	}
}
