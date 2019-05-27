package ru.job4j.tracker;

public class Menu {
    static String[] menu = {"0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by Id",
            "5. Find items by name",
            "6. Exit Program",
    };

    public static void show() {
        for (String s : menu) {
            System.out.println(s);
        }
    }
}

