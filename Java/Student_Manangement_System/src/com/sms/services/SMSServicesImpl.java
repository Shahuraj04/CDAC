package com.sms.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import com.sms.core.Course;
import com.sms.core.Student;
import com.sms.custom_exception.SMSCustomException;
import com.sms.studentValidation.SMSServiceValidations;

public class SMSServicesImpl implements SMSServices {

	ArrayList<Student> studentList = new ArrayList<>(); // initialize once before using

	SMSServiceValidations sv1 = new SMSServiceValidations();
	// didnt used static used instance of class validation

	public SMSServicesImpl() {

//		this.studentList = (ArrayList<Student>) studentList;
		studentList.add(new Student("shahu", "shahu@gmail.com", 99, LocalDate.parse("2003-12-12"), Course.CORE_JAVA));
		studentList.add(new Student("shahu", "shahu1@gmail.com", 99, LocalDate.parse("2003-12-12"), Course.DEV_OPS));
		studentList.add(new Student("shahu", "shahu3@gmail.com", 99, LocalDate.parse("2003-12-12"), Course.CORE_JAVA));
	}

	@Override
	public String registerStudent(String name, String email, int marks, String dob, String coursetype)
			throws SMSCustomException {

		// string to enum conversion
		// string to date conversion

		Student s = SMSServiceValidations.validateStudentInfo(name, email, marks, dob, coursetype, studentList);
//		Student s1 = new Student(name, email, marks, date, type);
		
		studentList.add(s);
		return "Registration successful !";

	}
	
	

	@Override
	public void getAllDetails() {
		for (Student s : studentList) {

			System.out.println(s);
		}

	}

	@Override
	public Student checkByEmail(String checkMail) throws SMSCustomException {
		for (Student s : studentList) {
			if (s.getEmail().equals(checkMail)) {
				return s;
			}
		}
		throw new SMSCustomException("No student registered with this email!!");
	}

	@Override
	public void cancelByEmail(String cancelEmail) throws SMSCustomException {
		int index = -1;
		for (Student s : studentList) {
			if (s.getEmail().equals(cancelEmail)) {
				index = studentList.indexOf(s);
			} else if (index == -1) {
				throw new SMSCustomException("No student registered with this email!!");

			}
		}
		studentList.remove(index);
		System.out.println("Admission Cancelled!!");

	}

	@Override
	public void sortByCourse() {
		Collections.sort(studentList);
		
	}

}
