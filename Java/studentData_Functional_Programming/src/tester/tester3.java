package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class tester3 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Student> studentMap = populateMap(populateList());

			/*
			 * 3.5 Display names of students enrolled in a specified subject , securing
			 * marks > specified marks i/p : subject name , marks
			 */
			System.out.print("Enter Subject : " );
			Subject sub  = Subject.valueOf(sc.next());
			Collection<Student> studentList = studentMap.values();
			studentList.stream()
			.filter(s -> s.getSubject()==sub)
			.forEach(s -> System.out.println(s));
			System.out.print("Enter securing marks : " );
			double securingMarks = sc.nextDouble();
			
			System.out.println("Students with securing marks: ");
			studentList.stream()
			.filter(s -> s.getSubject()==sub)
			.filter(s -> s.getGpa()>securingMarks)
			.forEach(s -> System.out.println(s));
		}
		
		
		
	}

}
