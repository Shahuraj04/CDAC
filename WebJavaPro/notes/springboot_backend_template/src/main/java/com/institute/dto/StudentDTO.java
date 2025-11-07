package com.institute.dto;

import com.institute.entities.Course;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class StudentDTO {

	@NotBlank
	private String firstName;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private int marks;
	@NotNull
	private Long course;

}
