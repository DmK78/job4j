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
     *
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

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student != null)
                .sorted((o1, o2) -> o2.getScore()-o1.getScore())
                .takeWhile(student -> student.getScore() >= bound)
                .collect(Collectors.toList());
    }

}
