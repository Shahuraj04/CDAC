package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.core.Student;

public class tester7 {

	public static void main(String[] args) {

		// Scanner sc = new Scanner(System.in);

		/* 3.9 Print names of home cities (no dups please !) of all Students */

	
		Map<String,Student> students = populateMap(populateList());
		
		List<String> uniqueList = students.values().stream()
		.map(s -> s.getAddress().getCity()) 
		.distinct()
		.collect(Collectors.toList());
	uniqueList.stream().
	forEach(s -> System.out.println(s));
	}
	
	

}
