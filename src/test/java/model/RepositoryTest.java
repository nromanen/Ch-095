package model;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RepositoryTest {

    Set<Student> students = new HashSet<>();
    Repository repository = new Repository(students);

    @Test
    public void populateStudents() {
        int sizeBefore = students.size();
        repository.populateStudents();
        int sizeAfter = students.size();
        assertTrue(sizeAfter > sizeBefore);
    }

    @Test
    public void addStudent() {
        repository.add(new Student("aa", "aa",2.5));
        repository.add(new Student("ab", "ab", 2.52));
        assertEquals(2, students.size());
    }

    @Test
    public void add() {
        repository.add(new Student("aa", "aa",2.5));
        repository.add(new Student("ab", "ab", 2.52));
        assertEquals(2, students.size());
    }

    @Test
    public void removeStudent() {
        repository.add(new Student("aa", "aa",2.5));
        repository.add(new Student("ab", "ab", 2.52));
        repository.removeStudent(new Student("ab", "ab", 2.52));
        assertEquals(1, students.size());
    }

    @Test
    public void findByName() {
        repository.add(new Student("aa", "aa",2.5));
        repository.add(new Student("aa", "bb",2.7));
        repository.add(new Student("aa", "cc",2.6));
        repository.add(new Student("ab", "ab", 2.52));
        Set<Student> studentSet = repository.findByName("aa");
        assertEquals(3, studentSet.size());
    }

    @Test
    public void removeByRank() {
        repository.add(new Student("aa", "aa",2.5));
        repository.add(new Student("aa", "bb",2.5));
        repository.add(new Student("ab", "ab", 2.52));
        repository.removeByRank(2.5);
        assertEquals(1, students.size());
    }

    @Test
    public void removeRankMoreCertain() {
        repository.add(new Student("aa", "aa",2.5));
        repository.add(new Student("aa", "bb",2.7));
        repository.add(new Student("aa", "cc",2.6));
        repository.add(new Student("ab", "ab", 2.52));
        repository.removeRankMoreCertain(2.55);
        assertEquals(2, students.size());
    }
}