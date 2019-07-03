package ru.job4j.scool;

import org.junit.Before;
import org.junit.Test;


import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Before
    public void initScool() {
    }

    School school = new School();
    List<Student> students = List.of(
            new Student(100),
            new Student(80),
            new Student(70),
            new Student(60),
            new Student(50),
            new Student(40),
            new Student(10));

    @Test
    public void whenStudentsRankFrom70To100() {
        List<Student> result = school.collect(students, student -> student.score > 70 && student.score <= 100);
        result.forEach(System.out::println);
        List<Student> expect = List.of(students.get(0), students.get(1));
        assertThat(result, is(expect));
    }

    @Test
    public void whenStudentsRankFrom50To70() {
        List<Student> result = school.collect(students, student -> student.score > 50 && student.score <= 70);
        result.forEach(System.out::println);
        List<Student> expect = List.of(students.get(2), students.get(3));
        assertThat(result, is(expect));
    }

    @Test
    public void whenStudentsRankFrom0To50() {
        List<Student> result = school.collect(students, student -> student.score <= 50);
        result.forEach(System.out::println);
        List<Student> expect = List.of(students.get(4), students.get(5), students.get(6));
        assertThat(result, is(expect));
    }
}
