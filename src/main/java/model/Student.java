package model;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private double rank;

	public Student(String firstName, String lastName, double rank) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rank = rank;
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

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, rank);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", rank=" + rank + "]";
	}

	public int compareTo(Student other){
		return lastName.compareTo(other.getLastName());
	}
}