package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    private final Tracker tracker = new Tracker();

    @Before


    @After


    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenReturnNewArray() {
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 223L);
        Item third = new Item("test3", "testDescription", 323L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.delete(second);
        Item result = tracker.findById(first.getId());
        assertThat(result.getName(), is(first.getName()));
        result = tracker.findById(third.getId());
        assertThat(result.getName(), is(third.getName()));
        int size = tracker.getPosition();
        assertThat(tracker.getPosition(), is(2));
    }

    @Test
    public void whenFindAllItemThenShowThree() {
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 223L);
        Item third = new Item("test3", "testDescription", 323L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] result = tracker.findAll();
        assertThat(result.length, is(3));
    }

    @Test
    public void whenFindByNameThenShowTwoItems() {
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 223L);
        Item third = new Item("test1", "testDescription", 323L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] result = tracker.findByName("test1");
        assertThat(result.length, is(2));
        assertThat(result[0].getName(), is("test1"));
        assertThat(result[1].getName(), is("test1"));
    }
}