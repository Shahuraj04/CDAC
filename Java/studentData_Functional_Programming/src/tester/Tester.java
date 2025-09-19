package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

import custom_exception.StudentCollectionException;

public class Tester {

	public static void main(String[] args) throws StudentCollectionException {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Student> studentMap = populateMap(populateList());

			studentMap.forEach((k, v) -> System.out.println(v));

			// 3.1 Display details of the students from specified subject

//		System.out.print("Enter Subject: ");
//		
//		String subName = sc.next();
//		Subject sub = Subject.valueOf(subName);
//		studentMap.values().stream()
//		.filter(s -> s.getSubject()==sub)
//		.forEach(s -> System.out.print(s));
//		
			// 3.2 Print sum of marks of students of all students from the specified state
			// i/p : name of the state

			// Comparator<Student> city = (s1,s2) -> s1.

//		System.out.println("Enter city:");
//
//		String cityName = sc.next();
//		Double sum = studentMap.values().stream().filter(s -> s.getAddress().getState().equals(cityName))
//				.mapToDouble(s -> s.getGpa()).sum();
//
//		System.out.println(sum);

			/*
			 * 3.3 Print name of specified subject topper i/p : subject name
			 */
			
			Comparator<Student> sorting = (s1,s2)->{
				if(s1.getGpa()>s2.getGpa()) 
					return 1;
				else if(s1.getGpa()<s2.getGpa())
					return -1;
				
				else 
					return 0;
							
				
			};
			 System.out.println("Enter Subject: ");
			String subTopper = sc.next();
			
			Subject topSub =Subject.valueOf(subTopper);
			Student s1 =  studentMap.values().stream()
			.filter(s -> s.getSubject().equals(topSub))
			.max(sorting)
			.orElseThrow(() -> new 	StudentCollectionException("No students with given subject"));

			 
			 System.out.println("Topper in "+topSub+" is "+ s1.getName()+" gpa: "+s1.getGpa() );
		}
	}

}
