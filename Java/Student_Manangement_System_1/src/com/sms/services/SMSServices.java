package com.sms.services;

import com.sms.core.Student;
import com.sms.custom_exception.SMSCustomException;

public interface SMSServices {
	
	 Student registerStudent(String name,String email,int marks,String dob,String courseType) throws SMSCustomException;

	void getAllDetails();

	Student checkByEmail(String checkMail) throws SMSCustomException;

	void cancelByEmail(String cancelEmail) throws SMSCustomException;

	void sortByCourse();

	void dataAdd();
	
	

}
