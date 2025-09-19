package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class tester2 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			/*
			 * 3.4 Print number of failures for the specified subject chosen from user. i/p
			 * : subject name (failure is GPA < 5.0 , out of 1-10)
			 */
			Map<String,Student> studentMap = populateMap(populateList());
			
			System.out.print("Enter subject: ");
			Subject sub = Subject.valueOf(sc.next());
			System.out.println("Failed Students in "+ sub);
			studentMap.values().stream()
			.filter(s -> s.getSubject()==sub && s.getGpa()<8.9)
			
			.forEach(s -> System.out.println(s));
		}

	}

}
