package com.institute.dto;

import java.time.LocalDate;

import com.institute.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDto {
	/*1.	ID (unique identifier for each Course, auto generated, starts from 1)
2.	Name (unique , Cannot be Blank, Example : Java SE,Web Programming in Java ,Spring Boot , Spring Cloud, Oracle DB , MySql DB  )
3.	Category (Enum, Example: JAVA,DBT)
4.	Start Date (Cannot be Blank)
5.	End Date (Cannot be Blank)
6.	Fees (Cannot be Blank)
7.	Marks to Pass (Cannot be Blank)
*/
	private Long courseId;
	@NotBlank
	private String name;
	@NotNull
	private Category category;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	@NotNull
	private double fees;
	@NotNull
	private int requiredMarks;
	
	

}
