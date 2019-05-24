package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean delete(Item item) {
        boolean result = false;
        int posToDel = findItemPos(item.getId());
        if (posToDel >= 0) {
            position--;
            result = true;
            System.arraycopy(items, posToDel + 1, items, posToDel, items.length - posToDel - 1);
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int posToReplace = findItemPos(id);
        if (posToReplace >= 0) {
            items[posToReplace] = item;
            result = true;
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = Arrays.copyOf(items, position);
        return result;
    }

    /**
     * сначала проверяет, сколько нужно позиций для результирующего массива, а потом зарполняет.
     *
     * @param key
     * @return Item[]
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                count++;
            }
        }
        Item[] result = new Item[count];
        for (int i = 0, k = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                result[k] = items[i];
                k++;
            }
        }
        return result;
    }

    public int findItemPos(String id) {
        int findId = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                findId = index;
                break;
            }
        }
        return findId;
    }

    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }

    private String generateId() {
        String result = System.currentTimeMillis() + String.valueOf(Math.random() * 100);
        return result;
    }
}