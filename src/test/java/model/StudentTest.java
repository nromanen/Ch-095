package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void compareTo() {
        Student student_1 = new Student("aa", "aa",2.5);
        Student student_2 = new Student("aa", "bb",2.7);
        Student student_3 = new Student("aa", "cc",2.6);
        assertTrue(student_1.compareTo(student_1) == 0
                         && student_3.compareTo(student_1) > 1
                         && student_3.compareTo(student_2) < 1);
    }
}