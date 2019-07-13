package ru.job4j.userconvert;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenConvertSuccess() {
        UserConvert userConvert = new UserConvert();
        List<User> users = List.of(new User("Ivan", "Moscow"), new User("Dmitry", "Ekaterinburg"), new User("Dmitry", "Ekaterinburg"));
        HashMap<Integer, User> result = userConvert.process(users);
        HashMap<Integer, User> expect = new HashMap<>() {{
            put(0, users.get(0));
            put(1, users.get(1));
            put(2, users.get(2));
        }};
        assertThat(result, is(expect));
    }
}
