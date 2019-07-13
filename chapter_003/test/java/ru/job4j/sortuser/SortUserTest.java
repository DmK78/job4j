package ru.job4j.sortuser;

import com.sun.javafx.UnmodifiableArrayList;
import org.junit.Before;
import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {


    @Before
    public void init() {
    }

    User userIvan = new User("Ivan", 34);
    User userPetr = new User("Petr", 30);
    User userFedor = new User("Fedor", 25);
    User userDmitry = new User("Dmitry", 41);
    User userPetr1 = new User("Petr", 31);


    @Test
    public void whenSortUsersByAge() {
        SortUser sortUser = new SortUser();
        List<User> users = List.of(
                userIvan, userPetr, userDmitry);
        Set<User> result = sortUser.sort(users);
        Set<User> expect = Set.of(userPetr, userIvan, userDmitry);
        expect.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortUsersByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> users = List.of(userDmitry, userFedor, userIvan, userPetr);
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = List.of(userIvan, userPetr, userFedor, userDmitry).stream()
                .sorted((o1, o2) -> o1.getName().length() - o2.getName().length()).collect(Collectors.toList());
        assertThat(result.toString(), is(expect.toString()));
    }

    @Test
    public void whenSortUsersByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> users = List.of(userDmitry, userFedor, userPetr1, userPetr, userIvan);
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expect = List.of(userFedor, userDmitry, userPetr, userIvan, userPetr1).stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getAge)).collect(Collectors.toList());
        assertThat(result, is(expect));
    }

}
