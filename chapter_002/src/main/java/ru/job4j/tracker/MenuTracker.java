package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();


    private final Consumer<String> output;

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
    /**
     * Константа меню для показа всех заявок.
     */
    private static final int ALL = 1;
    /**
     * Константа меню для редактирования заявки.
     */
    private static final int EDT = 2;
    /**
     * Константа меню для удаления заявки.
     */
    private static final int DEL = 3;
    /**
     * Константа меню для нахождения заявки по ИД заявки.
     */
    private static final int FBI = 4;
    /**
     * Константа меню для нахождения заявки по имени заявки.
     */
    private static final int FBN = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(ADD, "0. Add new Item"));
        this.actions.add(new ShowItems(ALL, "1. Show all items"));
        this.actions.add(new UpdateItem(EDT, "2. Edit item"));
        this.actions.add(new DeleteItem(DEL, "3. Delete item"));
        this.actions.add(new FindItemById(FBI, "4. Find item by Id"));
        this.actions.add(new FindItemsByName(FBN, "5. Find items by name"));
        this.actions.add(new ExitProgram(EXIT, "6. Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        output.accept("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    public class AddItem extends BaseAction {
        int key;
        String info;

        public AddItem(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    public class ShowItems extends BaseAction {
        int key;
        String info;

        public ShowItems(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Печать всех заявок --------------");
            List<Item> items = tracker.findAll();
            for (Item item : items) {
                output.accept(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()));
            }
        }
    }

    public class UpdateItem extends BaseAction {
        int key;
        String info;

        public UpdateItem(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Укажите ИД заявки для изменения:");
            Item item = tracker.findById(id);
            if (item != null) {
                String name = input.ask("Введите новое имя заявки ");
                String desc = input.ask("Введите новое описание заявки ");
                item.setName(name);
                item.setDesc(desc);
                if (tracker.replace(id, tracker.findById(id))) {
                    output.accept("ОК");
                } else {
                    output.accept("Заявка с таким ИД не найдена");
                }

            }

        }
    }

    public class DeleteItem extends BaseAction {
        int key;
        String info;

        public DeleteItem(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Укажите ИД заявки для удаления");
            if (tracker.findById(id) != null) {
                tracker.delete(tracker.findById(id));
                output.accept("ОК");
            } else {
                output.accept("Заявка с таким ИД не найдена");
            }
        }
    }

    public class FindItemById extends BaseAction {
        int key;
        String info;

        public FindItemById(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ИД заявки для поиска");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()));
            } else {
                output.accept("Заявка в таким ИД не найдена");
            }

        }

    }

    public class FindItemsByName extends BaseAction {
        int key;
        String info;

        public FindItemsByName(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки для поиска ");
            List<Item> items = tracker.findByName(name);
            for (Item item : items) {
                output.accept(String.format("ID %-6s Name %-30s Description %-30s Time %s", item.getId(), item.getName(), item.getDesc(), item.getTime()));
            }
        }
    }

    public class ExitProgram extends BaseAction {
        int key;
        String info;

        public ExitProgram(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

    }
}