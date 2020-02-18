package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


public class RepositoryTest {
    private static Set<Student> studentSet = new HashSet<>();
    private  Student student = new Student("aa", "aa", 2.5);

    static Stream<Repository> methodToTest() {
        return Stream.of(new Repository(studentSet));
    }

    @ParameterizedTest
    @MethodSource("methodToTest")
    public void populateStudentTest(Repository repository) {
        int studentRepoSizeBefore = repository.getStudents().size();
        repository.populateStudents();
        int studentRepoSizeAfter = repository.getStudents().size();
        assertTrue(studentRepoSizeAfter > studentRepoSizeBefore);
    }

    @ParameterizedTest
    @MethodSource("methodToTest")
    public void removeStudentTest(Repository repository) {
        repository.populateStudents();
        Student firstStudent = new Student("aa", "aa", 2.5);
        boolean firstFlag = repository.removeStudent(firstStudent);
        assertTrue(firstFlag);
        Student secondStudent = new Student("aa", "aa", 12);
        boolean secondFlag = repository.removeStudent(secondStudent);
        assertFalse(secondFlag);
    }

    @ParameterizedTest
    @MethodSource("methodToTest")
    public void findByNameTest(Repository repository) {
        repository.populateStudents();
        String studentName = "aa";
        Set<Student> studentSet = repository.findByName(studentName);
        assertNotNull(studentSet);
        assertEquals(studentSet.size(), 1);
    }

    @ParameterizedTest
    @MethodSource("methodToTest")
    public void removeByRankTest(Repository repository) {
        repository.populateStudents();
        double rank = 2.5;
        repository.removeByRank(rank);
        assertEquals(repository.getStudents().size(), 2);
    }

    @ParameterizedTest
    @MethodSource("methodToTest")
    public void addStudentTest(Repository repository) {
        boolean firstFlag = repository.addStudent(student);
        assertTrue(firstFlag);
        boolean secondFlag = repository.add(student);
        assertFalse(secondFlag);
    }

    @ParameterizedTest
    @MethodSource("methodToTest")
    public void setStudentTest(Repository repository) {
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student);
        repository.setStudents(studentSet);
        assertEquals(studentSet, repository.getStudents());
    }
}