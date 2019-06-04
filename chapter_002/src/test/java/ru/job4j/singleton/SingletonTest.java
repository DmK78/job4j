package ru.job4j.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SingletonTest {

    @Test
    public void whenSingleton1NotDuplicates() {
        Singleton1 singleton = Singleton1.getInstance();
        assertTrue(singleton == Singleton1.getInstance());
    }

    @Test
    public void whenSingleton2NotDuplicates() {
        Singleton2 singleton = Singleton2.getInstance();
        assertTrue(singleton == Singleton2.getInstance());
    }

    @Test
    public void whenSingleton3NotDuplicates() {
        Singleton3 singleton = Singleton3.getInstance();
        assertTrue(singleton == Singleton3.getInstance());
    }

    @Test
    public void whenSingleton4NotDuplicates() {
        Singleton4 singleton = Singleton4.INSTANCE;
        assertTrue(singleton == Singleton4.INSTANCE);
    }
}
