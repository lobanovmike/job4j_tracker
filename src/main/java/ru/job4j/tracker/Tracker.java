package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                rsl[size] = item;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                rsl[size] = item;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    private int indexOf(int id) {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
                index = i;
            }
        }
        return index;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }
}