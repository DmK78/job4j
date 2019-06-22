package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        item.setTime(System.currentTimeMillis());
        this.items.add(this.position++, item);
        return item;
    }

    public boolean delete(Item item) {
        boolean result = false;
        int posToDel = findItemPos(item.getId());
        if (posToDel >= 0) {
            position--;
            result = true;
            items.remove(posToDel);
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int posToReplace = findItemPos(id);
        if (posToReplace >= 0) {
            items.add(posToReplace, item);
            result = true;
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        //result = items.subList(0, position);
        result = items;
        return result;
    }

    /**
     * сначала проверяет, сколько нужно позиций для результирующего массива, а потом зарполняет.
     *
     * @param key
     * @return ArrayList<Item>
     */
    public ArrayList<Item> findByName(String key) {
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (items.get(i).getName().equals(key)) {
                count++;
            }
        }
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0, k = 0; i < position; i++) {
            if (items.get(i).getName().equals(key)) {
                result.add(k, items.get(i));
                k++;
            }
        }
        return result;
    }

    public int findItemPos(String id) {
        int findId = -1;
        for (int index = 0; index < position; index++) {
            if (items.get(index).getId().equals(id)) {
                findId = index;
                break;
            }
        }
        return findId;
    }

    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < position; index++) {
            if (items.get(index).getId().equals(id)) {
                result = items.get(index);
                break;
            }
        }
        return result;
    }

    private String generateId() {
        String result = String.valueOf((int) (Math.random() * 1000));
        return result;
    }
}