package com.sms.studentValidation;

import java.time.LocalDate;
import java.util.ArrayList;

import com.sms.core.Course;
import com.sms.core.Student;
import com.sms.custom_exception.SMSCustomException;

public class SMSServiceValidations {

	public static Student validateStudentInfo(String name, String email, int marks, String dob, String coursetype,
			ArrayList<Student> studentList) throws SMSCustomException {
		validateEmail(email, studentList);
		validateEmailFormat(email);
		Course type = Course.valueOf(coursetype.toUpperCase());

		validateMarks(marks, type);
		LocalDate date = LocalDate.parse(dob);

		return new Student(name, email, marks, date, type); // created new student after validating info
	}
	
	public static void validateEmailFormat(String email) throws SMSCustomException {
		String emailRegEx = "^[a-z][a-z0-9._-]*@[a-z]+\\.(com|org|net)$";
		if (!email.matches(emailRegEx))
			throw new SMSCustomException("Invalid Email Format!!!!");
	}

	private static void validateMarks(int marks, Course type) throws SMSCustomException, IllegalArgumentException {

		if (marks < type.getMin_marks()) {
			throw new SMSCustomException("Minimum marks requred for " + type.getPlan() + " is " + type.getMin_marks()); // getting
																														// course
																														// type
																														// and
																														// course
																														// marks
																														// from
																														// ENUM
		}

	}

	private static void validateEmail(String email, ArrayList<Student> studentList) throws SMSCustomException {
		for (Student s : studentList) {
			if (s.getEmail().equalsIgnoreCase(email)) {
				throw new SMSCustomException("Student Already registered!!");
			}
		}
	}

}
