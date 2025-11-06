package com.institute.dto;

import com.institute.entities.Course;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {

	private String firstName;
	private String email;
	private String password;
	private int marks;
	private Course course;

}
