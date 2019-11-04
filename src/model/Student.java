package model;

import java.util.Objects;
import java.util.Random;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private double rank;

	public Student(String firstName, String lastName, double rank) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank=rank;
	}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", rank=" + rank + "]";
	}
	public int compareTo(Student other){
		if( lastName.compareTo(other.getLastName()) == -1 |
				firstName.compareTo(other.getLastName()) == -1){
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Double.compare(student.rank, rank) == 0 &&
				Objects.equals(firstName, student.firstName) &&
				Objects.equals(lastName, student.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, rank);
	}
}
