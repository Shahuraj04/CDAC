package com.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeptUpdationDTO {

	
	
	@NotNull
	private Long deptId;
	@NotBlank
	private String deptName;
	@NotBlank
	private String location;
	@NotNull
	private Double budget;
	@NotBlank
	private String managerName;
}
