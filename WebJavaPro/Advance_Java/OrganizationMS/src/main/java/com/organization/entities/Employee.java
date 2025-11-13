package com.organization.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "Name")	
	private String empName;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "sal")
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "departmentId", nullable = false)
	private Department department;
}
