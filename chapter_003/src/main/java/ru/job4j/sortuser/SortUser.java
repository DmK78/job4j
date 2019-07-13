package ru.job4j.sortuser;

import java.util.*;
import java.util.stream.Collectors;

public class SortUser {

    /**
     * будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     *
     * @return
     */
    public Set<User> sort(List<User> list) {
        return list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toSet());
    }

    public List<User> sortNameLength(List<User> list) {
        return list.stream().sorted(Comparator.comparing(user -> user.getName().length())).collect(Collectors.toList());
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge)).collect(Collectors.toList());
    }

}
