package main;

import java.io.IOException;
import java.util.*;

import model.Repository;
import model.Student;

public class Main {
	public static void main(String ...strings ) throws IOException {
		Set<Student> students = new HashSet<>();
		Repository rep = new Repository(students);
//		 rep.populateStudents();
//        rep.populateStudentsFromJson("test.json");
		List<Student> studentsByName = new ArrayList<>();
		studentsByName.addAll(students);
		Student firstStudent = new Student("aa", "aa",2.5);
		rep.addStudent(firstStudent);
		rep.removeStudent(firstStudent);
		rep.removeByRank(2.52);
		System.out.println(students);
	}
}
