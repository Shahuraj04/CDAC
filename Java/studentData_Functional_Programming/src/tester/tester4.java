package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class tester4 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Student> studentMap = populateMap(populateList());

			/*
			 * 3.6 Suppose a particular subject faculty is unavailable for few days. So you
			 * have to infor the students of specified subjec. Collect the specified subject
			 * students into the list n display it. i/p : subject name
			 */
			System.out.print("Enter Subject name: ");
			Subject sub = Subject.valueOf(sc.next());
			
			System.err.println("Students admitted for subject "+ sub+" :");
			studentMap.values().stream()
			.filter(s -> s.getSubject()==sub)
			.forEach(s -> System.out.println(s));
		}

	}

}
