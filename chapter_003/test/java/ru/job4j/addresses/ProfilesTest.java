package ru.job4j.addresses;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.scool.School;
import ru.job4j.scool.Student;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Before
    public void init() {
    }

    Profiles profiles = new Profiles();
    List<Profile> users = List.of(
            new Profile(new Address("Moscow", "Lenina", 2, 23)),
            new Profile(new Address("Ekaterinburg", "Moskovskaya", 3, 20)),
            new Profile(new Address("Sochi", "Kurortnaya", 5, 1))
    );

    @Test
    public void whenListAddressessSuccess() {
        List<Address> result = profiles.collect(users);
        List<Address> expect = List.of(users.get(0).getAddress(), users.get(1).getAddress(), users.get(2).getAddress());
        assertThat(result, is(expect));
    }


}
