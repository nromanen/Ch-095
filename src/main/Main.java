package main;

import model.Repository;
import model.Student;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String... strings) throws IOException {
        Set<Student> students = new HashSet<>();
        Repository rep = new Repository(students);
        rep.populateStudents("test.json");
        List<Student> studentsByName = new ArrayList<>();
        studentsByName.addAll(students);
        Student firstStudent = new Student("aa", "aa", 2.5);
        rep.addStudent(firstStudent);
        rep.removeStudent(firstStudent);
        rep.removeByRank(2.52);
        System.out.println(students);
    }
}

