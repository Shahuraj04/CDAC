package com.institute.dto;

import jakarta.validation.constraints.Email;
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
public class StudentDTO {

	@NotBlank
	public String firstName;
	@Email
	@NotNull
	public String email;
	@NotNull
	public String password;
	@NotNull
	public int marks;
	@NotNull
	public Long courseId;

}
