package ru.job4j.sortuser;

import org.junit.Test;


import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSort3UsersByAge() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan",34));
        users.add(new User("Petr",30));
        users.add(new User("Dmitry",41));
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new LinkedHashSet<>();
        expect.add(users.get(2));
        expect.add(users.get(0));
        expect.add(users.get(1));
        assertThat(result.toString(), is(expect.toString()));
    }

    @Test
    public void whenSortUsersByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("Dmitry",41));
        users.add(new User("Petro",30));
        users.add(new User("Ivan",34));
        users.add(new User("Petro",30));
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = new ArrayList<>();
        expect.add(new User("Ivan",34));
        expect.add(new User("Petro",30));
        expect.add(new User("Petro",30));
        expect.add(new User("Dmitry",41));
        assertThat(result.toString(), is(expect.toString()));
    }
}
