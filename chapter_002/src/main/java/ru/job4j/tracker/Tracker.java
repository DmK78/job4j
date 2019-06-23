package ru.job4j.tracker;

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
        if (findItemPos(item.getId()) != -1) {
            result = true;
            items.remove(findItemPos(item.getId()));
            position--;
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int position = findItemPos(id);
        if (position != -1) {
            result = true;
            items.set(position, item);
        }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    /**
     *
     *
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