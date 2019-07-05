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
            new Student("Ivan", "Ivanov", 100),
            new Student("Vasily", "Pupkin", 80),
            new Student("Georgy", "Jukov", 70),
            new Student("Semyon", "Altov", 60),
            new Student("Maxim", "Maximov", 50),
            new Student("Fedor", "Konyukhov", 40),
            new Student("Arseny", "Denov", 10));

    @Test
    public void whenConvertStudentsListToMap() {
        Map<String, Student> result = school.convertStudentsListToMap(students);
        TreeMap<String, Student> expect = new TreeMap<>(Map.of("Altov", students.get(3), "Denov", students.get(6), "Ivanov", students.get(0), "Jukov", students.get(2),
                "Konyukhov", students.get(5), "Maximov", students.get(4), "Pupkin", students.get(1)));
        assertThat(result, is(expect));
    }


    @Test
    public void whenStudentsRankFrom70To100() {
        List<Student> result = school.collect(students, student -> student.getScore() > 70 && student.getScore() <= 100);
        List<Student> expect = List.of(students.get(0), students.get(1));
        assertThat(result, is(expect));
    }

    @Test
    public void whenStudentsRankFrom50To70() {
        List<Student> result = school.collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        List<Student> expect = List.of(students.get(2), students.get(3));
        assertThat(result, is(expect));
    }

    @Test
    public void whenStudentsRankFrom0To50() {
        List<Student> result = school.collect(students, student -> student.getScore() <= 50);
        List<Student> expect = List.of(students.get(4), students.get(5), students.get(6));
        assertThat(result, is(expect));
    }
}
