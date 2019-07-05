package ru.job4j.scool;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {


    /**
     * Фильтрует школьников по предикату
     *
     * @param students
     * @param predict
     * @return
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    /**
     * преобразует список студентов в map, ключом является lastname
     * @param students
     * @return
     */
    Map<String, Student> convertStudentsListToMap(List<Student> students) {
        Map<String, Student> result = new LinkedHashMap<>(students.stream().collect(
                Collectors.toMap(
                        e -> e.getLastName(),
                        e -> e
                )));
        return result;

    }

    public static void main(String[] args) {
       /* School school = new School();
        List<Student> students = List.of(
                new Student(100),
                new Student(70),
                new Student(10)
        );
        List<Student> result = school.collect(students, student -> student.score > 50);
        //result.forEach(System.out::println);*/
    }
}
