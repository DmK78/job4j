package ru.job4j.scool;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

    Map<String, Student> convertStudentsListToMap(List<Student> students) {
        TreeMap<String, Student> result = new TreeMap<>(students.stream().distinct().collect(
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
