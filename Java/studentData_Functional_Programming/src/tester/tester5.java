package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class tester5 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Student> studentMap = populateMap(populateList());

			/* 3.7 Display student details for specified subject , 
			 * sorted as per DoB */
			
			System.out.print("Enter subject: ");
			Subject sub = Subject.valueOf(sc.next());
			
			Comparator<Student> sortedByDob = (s1,s2) -> s1.getDob().compareTo(s2.getDob());
			
			studentMap.values().stream()
			.filter(s -> s.getSubject()==sub)
			.sorted(sortedByDob)
			.forEach(s -> System.out.println(s));
		}

	}
}
