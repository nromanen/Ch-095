package main;



import java.util.*;

import model.Repository;
import model.Student;

public class Main {
	public static void main(String ...strings ){
		Set<Student> students = new HashSet<>();
		Repository rep = new Repository(students);
		 rep.populateStudents();
		//for (Student student: students) {
			System.out.println(students);
		//}
		List<Student> studentsByName = new ArrayList<>();
		studentsByName.addAll(students);
		Student firstStudent = new Student("aa", "aa");
		//rep.addStudent(firstStudent);
		rep.removeStudent(firstStudent);
		//rep.removeByRank(2.52);
		System.out.println(students);
	}
}

// User can add two students with the same first and last name.
// User can't remove student with certain first and last name
// Create method for deleting students with rank more than one.
// Create method for sorting students by rank.
// Create unit tests.
// Create method to populate list of students from json-format.
// Convert project to gradle-project.