package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SingletonTest {

    @Test
    public void whenSingleton1NotDuplicates(){
        Singleton1 singleton=Singleton1.getInstance();
        assertThat(singleton, is(Singleton1.getInstance()));
    }
    @Test
    public void whenSingleton2NotDuplicates(){
        Singleton2 singleton=Singleton2.getInstance();
        assertThat(singleton, is(Singleton2.getInstance()));
    }
    @Test
    public void whenSingleton3NotDuplicates(){
        Singleton3 singleton=Singleton3.getInstance();
        assertThat(singleton, is(Singleton3.getInstance()));
    }
    @Test
    public void whenSingleton4NotDuplicates(){
        Singleton4 singleton=Singleton4.INSTANCE;
        assertThat(singleton, is(Singleton4.INSTANCE));
    }
}
