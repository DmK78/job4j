package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenTrackerShowTwoItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "0", "test2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
        assertThat(tracker.findAll()[1].getName(), is("test2"));
    }

    @Test
    public void whenWhenItemDeleted() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        Item[] itemEmpty = new Item[0];
        assertThat(tracker.findAll(), is(itemEmpty));
    }

    @Test
    public void whenFindById() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenFindByName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
        assertThat(tracker.findByName(item2.getName())[1].getName(), is("test name"));

    }
}
