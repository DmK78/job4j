package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder menu = new StringBuilder()
            .append("Меню." + System.lineSeparator())
            .append("0. Add new Item" + System.lineSeparator())
            .append("1. Show all items" + System.lineSeparator())
            .append("2. Edit item" + System.lineSeparator())
            .append("3. Delete item" + System.lineSeparator())
            .append("4. Find item by Id" + System.lineSeparator())
            .append("5. Find items by name" + System.lineSeparator())
            .append("6. Exit Program");

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();     // создаём Tracker
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
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "0", "test2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test1"));
        assertThat(tracker.findAll()[1].getName(), is("test2"));
    }

    @Test
    public void whenItemDeleted() {
        Tracker tracker = new Tracker();     // создаём Tracker
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
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        //assertThat(tracker.findById(item.getId()),
        StringBuilder expected = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator())
                .append(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()))
                .append(System.lineSeparator())
                .append(menu)
                .append(System.lineSeparator());
        assertThat(out.toString(), is(expected.toString()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
        assertThat(tracker.findByName(item2.getName())[1].getName(), is("test name"));
        StringBuilder expected = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator())
                .append(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()))
                .append(System.lineSeparator())
                .append(String.format("ID %-6s Name %-30s Description %-30s Time %s", item2.getId(), item2.getName(), item2.getDesc(), item.getTime()))
                .append(System.lineSeparator())
                .append(menu)
                .append(System.lineSeparator());
        assertThat(out.toString(), is(expected.toString()));

    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc"));
        Item item1 = tracker.add(new Item("test name1", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder expected = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Печать всех заявок --------------")
                .append(System.lineSeparator())
                .append(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()))
                .append(System.lineSeparator())
                .append(String.format("ID %-6s Name %-30s Description %-30s Time %s", item1.getId(), item1.getName(), item1.getDesc(), item1.getTime()))
                .append(System.lineSeparator())
                .append(String.format("ID %-6s Name %-30s Description %-30s Time %s", item2.getId(), item2.getName(), item2.getDesc(), item2.getTime()))
                .append(System.lineSeparator())
                .append(menu)
                .append(System.lineSeparator());
        assertThat(out.toString(), is(expected.toString()));

    }
}
