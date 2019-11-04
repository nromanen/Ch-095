package model;

import com.google.gson.Gson;

import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Repository {
    Set<Student> students;

    public Repository(Set<Student> students) {
        super();
        this.students = students;
    }

    public void populateStudents() throws IOException, JAXBException {
        students = readFromJson("test.json");
    }

    private Set<Student> readFromJson(String path) throws IOException, JAXBException {
        Repository students = new Gson().fromJson(new FileReader(path), Repository.class);
        Set<Student> res = students.students;
        return res;
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public boolean add(Student student) {
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        for (Student currentStudent : students) {
            if (student.equals(currentStudent)) {
                return students.remove(student);
            }
        }
        return false;
    }

    public Set<Student> findByName(String name) {
        return students.stream().filter(st -> st.getFirstName().equals(name)).collect(Collectors.toSet());
    }

    public void removeByRank(double rank) {
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getRank() == rank) {
                iter.remove();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        for (Student s : that.students) {
            if (!this.students.contains(s)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
    }


}
