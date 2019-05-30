package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String ALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";
    /**
     * Константа меню для нахождения заявки по ИД заявки.
     */
    private static final String FBI = "4";
    /**
     * Константа меню для нахождения заявки по имени заявки.
     */
    private static final String FBN = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            System.out.println(this.showMenu());
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.findAll();
            } else if (EDT.equals(answer)) {
                this.editItem();
            } else if (DEL.equals(answer)) {
                this.deleteItem();
            } else if (FBI.equals(answer)) {
                this.findById();
            } else if (FBN.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Метод реализует печать всех заявок.
     */
    private void findAll() {
        System.out.println("------------ Печать всех заявок --------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()));
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        String id = input.ask("Укажите ИД заявки для изменения:");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.ask("Введите новое имя заявки ");
            String desc = input.ask("Введите новое описание заявки ");
            item.setName(name);
            item.setDesc(desc);
            if (tracker.replace(id, tracker.findById(id))) {
                System.out.println("ОК");
            }
        } else {
            System.out.println("Заявка с таким ИД не найдена");
        }

    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        String id = input.ask("Укажите ИД заявки для удаления");
        if (tracker.delete(tracker.findById(id))) {
            System.out.println("ОК");
        } else {
            System.out.println("Заявка с таким ИД не найдена");
        }
    }

    /**
     * Метод реализует нахождение заявки по ИД.
     */
    private void findById() {
        String id = input.ask("Введите ИД заявки для поиска");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()));
        } else {
            System.out.println("Заявка в таким ИД не найдена");
        }
    }

    /**
     * Метод реализует нахождение заявки по имени.
     */
    private void findByName() {
        String name = input.ask("Введите имя заявки для поиска ");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()));
        }
    }
}