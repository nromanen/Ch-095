package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class RepositoryTest {
    private Set<Student> studentSet = new HashSet<>();
    private Student student = new Student("aa", "aa", 2.5);
    private Repository repository = new Repository(studentSet);

    @Before
    public void setUp() {
        repository.populateStudents();
    }

    @Test
    public void populateStudentTest() {
        int actualSize = repository.getStudents().size();
        assertEquals("Size of repository must be 2", actualSize, 2);
    }

    @Test
    public void removeStudentTest() {
        Student firstStudent = new Student("aa", "aa", 2.5);
        boolean firstFlag = repository.removeStudent(firstStudent);
        assertTrue(firstFlag);
    }

    @Test
    public void findByNameTest() {
        String studentName = "aa";
        Set<Student> studentSet = repository.findByName(studentName);
        assertNotNull(studentSet);
        assertEquals("Size of repository must be 2", studentSet.size(), 1);
    }

    @Test
    public void removeByRankTest() {
        double rank = 2.5;
        repository.removeByRank(rank);
        assertEquals(repository.getStudents().size(), 1);
    }

    @Test
    public void addStudentTest() {
        boolean firstFlag = repository.addStudent(student);
        assertTrue(firstFlag);
        boolean secondFlag = repository.add(student);
        assertFalse(secondFlag);
    }

    @Test
    public void setStudentTest() {
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student);
        repository.setStudents(studentSet);
        assertEquals(studentSet, repository.getStudents());
    }
}