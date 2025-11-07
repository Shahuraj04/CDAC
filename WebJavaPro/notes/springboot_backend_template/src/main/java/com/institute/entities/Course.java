package com.institute.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor

@Table(name = "courses")
public class Course {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long courseId;
	@Column(name = "course_name", unique = true)
	private String name;
	/*
	 * Course has the following attributes: 1. ID (unique identifier for each
	 * Course, auto generated, starts from 1) 2. Name (unique , Cannot be Blank,
	 * Example : Java SE,Web Programming in Java ,Spring Boot , Spring Cloud, Oracle
	 * DB , MySql DB ) 3. Category (Enum, Example: JAVA,DBT) 4. Start Date (Cannot
	 * be Blank) 5. End Date (Cannot be Blank) 6. Fees (Cannot be Blank) 7. Marks to
	 * Pass (Cannot be Blank)
	 */
	public Course(String name2, Category category2, LocalDate startDate2, LocalDate endDate2, double fees2,
			int requiredMarks2) {
		this.name = name2;
		this.category = category2;
		this.startDate = startDate2;
		this.endDate = endDate2;
		this.fees = fees2;
		this.requiredMarks = requiredMarks2;
	}
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "fees")
	private double fees;
	@Column(name = "marks_required")
	private int requiredMarks;

}
