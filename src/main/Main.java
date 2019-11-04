package main;

import java.util.*;

import model.Repository;
import model.Student;

public class Main {

	public static void main(String ...strings ){
		Set<Student> students = new HashSet<>();
		Repository rep = new Repository(students);
		 rep.populateStudents();
		Student firstStudent = new Student("aa", "aa",2.5);
		rep.addStudent(firstStudent);
		rep.addStudent(new Student("first","ac",2.57));
		rep.addStudent(new Student("third","acc",2.51));
		rep.addStudent(new Student("second","acc",2.54));
		rep.removeStudent(firstStudent);
		rep.removeByRank(2.52);
		System.out.println(rep.getSortedStudentsByRank());
	}

}

