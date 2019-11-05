package model;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {
	Set<Student> students;
	
	public Repository(Set<Student> students) {
		super();
		this.students = students;
	}

	public void populateStudents(){
		students.add(new Student("aa", "aa",2.5));
		students.add(new Student("ab", "ab", 2.52));
	}

	public void populateStudentsFromJson(String path) throws IOException {
		students = readFromJson(path);
	}

	private Set<Student> readFromJson(String path) throws IOException {
		return new HashSet<>(Arrays.asList(new Gson().fromJson(new FileReader(path), Student[].class)));
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

	public void removeRankMoreCertain(double rank){
		Iterator<Student> iter=students.iterator();
		while(iter.hasNext()){
			Student student=iter.next();
			if (student.getRank() > rank){
				iter.remove();
			}
		}
	}

	public List<Student> getSortedByRank(){
		return students.stream()
				.sorted()
				.collect(Collectors.toList());
	}

}
