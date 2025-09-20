package com.sms.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.sms.core.Student;
import com.sms.custom_exception.SMSCustomException;
import com.sms.studentValidation.SMSServiceValidations;

public class SMSServicesImpl implements SMSServices {

	ArrayList<Student> studentList;
	private String fileName;

	SMSServiceValidations sv1 = new SMSServiceValidations();

	public SMSServicesImpl(String fileName) {
		this.fileName = fileName;

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {

			studentList = (ArrayList<Student>) in.readObject();

		} catch (Exception e) {
			studentList = new ArrayList<>();
		}
	}

	@Override
	public Student registerStudent(String name, String email, int marks, String dob, String coursetype)
			throws SMSCustomException {

		Student s = SMSServiceValidations.validateStudentInfo(name, email, marks, dob, coursetype, studentList);

		studentList.add(s);
		return s;

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
		Collections.sort(studentList, (s1, s2) -> s1.getCourseType().compareTo(s2.getCourseType()));
		;
		for (Student s : studentList) {
			System.out.println(s);
		}
	}

	@Override
	public void dataAdd() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(studentList);
			System.out.println("Data saved successfully to " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
