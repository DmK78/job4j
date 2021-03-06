package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class Tracker {
    private List<Item> items = new ArrayList<>();
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
        if (posToDel != -1) {
            result = true;
            items.remove(posToDel);
            this.position--;
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int posToReplace = findItemPos(id);
        if (posToReplace >= 0) {
            //items.add(posToReplace, item);
            result = true;
            items.set(posToReplace, item);
        }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    /**
     * @param key
     * @return ArrayList<Item>
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public int findItemPos(String id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (id.equals(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        //String result = System.currentTimeMillis() + String.valueOf(Math.random() * 100);
        // изменил генерацию проще поиск делать
        String result = String.valueOf((int) (Math.random() * 1000));
        return result;
    }
}