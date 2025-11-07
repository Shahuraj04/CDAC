package com.institute.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "students")
@AttributeOverride(name="id", column = @Column(name="student_id"))

public class Student extends BaseEntity {
	
	@Column(name = "first_name", length = 30) 
	private String firstName;
	@Column(name = "email", length = 30) // col name , varchar size
	private String email;
	@Column(name = "password", length = 30) // col name , varchar size
	private String password;
	@Column(name="marks")
	private int marks;
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	

}
