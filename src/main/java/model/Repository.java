package model;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Repository {
	Set<Student> students;

	public Repository() {
	}

	public Repository(Set<Student> students) {
		super();
		this.students = students;
	}


	public void populateStudents(){
		students.add(new Student("aa", "aa",2.5));
		students.add(new Student("ab", "ab", 2.52));
	}

	public boolean addStudent(Student student){
		return students.add(student);
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public boolean add(Student student){
		return students.add(student);
	}

	public boolean removeStudent(Student student){
		for (Student currentStudent: students){
			if (student.equals(currentStudent)){
				return students.remove(student);
			}
		}
		return false;
	}

	public Set<Student> findByName(String name){
		return students.stream().filter(st -> st.getFirstName().equals(name)).collect(Collectors.toSet());
	}

	public void removeByRank(double rank){
		Iterator<Student> iter=students.iterator();
		while(iter.hasNext()){
			Student student=iter.next();
			if (student.getRank()==rank){
				iter.remove();
			}
		}
	}


	public List<Student> getSortedStudentsByRank() {
		return students.stream().sorted(Student::compareTo).collect(Collectors.toList());
	}

	public void populateStudentsFromJson(String path){
		
		try {
			// create Gson instance
			Gson gson = new Gson();
			// create a reader
			Reader reader = Files.newBufferedReader(Paths.get(path));
			// convert JSON array to list of students
			students.addAll(Arrays.asList(gson.fromJson(reader, Student[].class)));
			// close reader
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}