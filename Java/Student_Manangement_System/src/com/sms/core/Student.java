package com.sms.core;

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	
	

	private int id;
	private String name;
	private String email;
	private int marks;
	private Course courseType;
	private static int idCounter;
	private LocalDate dob;
	
	public Student(String name, String email, int marks, LocalDate dob,Course courseType) {
		 
		this.id = ++idCounter;
		this.name = name;
		this.email = email;
		this.marks = marks;
		this.dob= dob;
		this.courseType = courseType;
	}
	
	public Student(String email2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Course getCourseType() {
		return courseType;
	}

	public void setCourseType(Course courseType) {
		this.courseType = courseType;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", marks=" + marks + ", courseType="
				+ courseType + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.courseType.name().compareTo(o.courseType.name());
		
	}
	

}
