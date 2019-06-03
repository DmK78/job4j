package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> ranges = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            ranges.add(i);
        }
        int choice = 10;
        while (choice != 6) {
            menu.show();
            choice = input.ask("select:", ranges);
            menu.select(choice);
        }
    }

    public String showMenu() {
        StringBuilder menu = new StringBuilder()
                .append("Меню." + System.lineSeparator())
                .append("0. Add new Item" + System.lineSeparator())
                .append("1. Show all items" + System.lineSeparator())
                .append("2. Edit item" + System.lineSeparator())
                .append("3. Delete item" + System.lineSeparator())
                .append("4. Find item by Id" + System.lineSeparator())
                .append("5. Find items by name" + System.lineSeparator())
                .append("6. Exit Program");
        return menu.toString();
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

}