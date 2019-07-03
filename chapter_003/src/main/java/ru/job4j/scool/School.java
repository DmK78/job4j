package ru.job4j.scool;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args) {

        School school = new School();
        List<Student> students = List.of(
                new Student(100),
                new Student(70),
                new Student(10)
        );

        List<Student> result = school.collect(students, student -> student.score > 50);
        result.forEach(System.out::println);
    }
}
