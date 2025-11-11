package com.institute.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CourseUpdateDto {

	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	
}
