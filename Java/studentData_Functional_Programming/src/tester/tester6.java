package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

public class tester6 {
	public static void main(String[] args) {

		

		Map<String, Student> studentMap = populateMap(populateList());

		/*
		 * 3.8 Find any student with GPA above 8 (Should run as short circuit operation,
		 * meaning the moment you come across any student with GPA > 10 , the streams
		 * should stop iterating & return the result immediately)
		 */
		
		boolean get = studentMap.values().stream()
		.anyMatch(s -> s.getGpa()>10);
		
		if(get==true) {
			System.out.println("Student found");
		}
		if(get==false) {
			System.out.println("Student not found");
		}
		

	}

}
