package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student firstStudent;
    private Student secondStudent;

    @Before
    public void setUp() {
        firstStudent = new Student("aa", "aa", 2.5);
        secondStudent = new Student("aab", "aab");
    }

    @Test
    public void setRankTest() {
        double rank = 3;
        secondStudent.setRank(rank);
        assertEquals(rank, secondStudent.getRank(), 0);
    }

    @Test
    public void compareStudentsTest() {
        secondStudent.setFirstName("aa");
        secondStudent.setLastName("aa");
        int compareTo = firstStudent.compareTo(secondStudent);
        assertEquals(compareTo, 0);
    }
}
