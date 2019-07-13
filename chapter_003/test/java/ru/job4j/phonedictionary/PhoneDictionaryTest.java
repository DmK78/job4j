package ru.job4j.phonedictionary;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFind2PersonsByName() {
        var phones = new PhoneDictionary();
        var person1 = new Person("Petr", "Arsentev", "534872", "Bryansk");
        var person2 = new Person("Dmitry", "Kolganov", "234872", "Ekaterinburg");
        var person3 = new Person("Vasily", "Popkov", "54872", "Ekaterinburg");
        phones.add(person1);
        phones.add(person2);
        phones.add(person3);
        var persons = phones.find("Ekaterinburg");
        var expect = List.of(person2, person3);
        assertThat(persons, is(expect));
    }
}
