package com.example.spring.Database;

import com.example.spring.model.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Database {
    public static ArrayList<Item> items = new ArrayList<Item>();
    private static Long idCounter = 9L;

    static {
//        items.add(new Item(1L, "Iphone 13", 700000,"Kazakhstan", "description 1"));
        items.add(new Item(2L, "Xiaomi Redmi Note 9", 100000, "description 2"));
        items.add(new Item(3L, "Samsung s22", 20, "description 3"));
        items.add(new Item(4L, "Samsung s22", 500000, "description 3"));
        items.add(new Item(5L, "Samsung s22", 40, "description 3"));
        items.add(new Item(6L, "Samsung s22", 500000, "description 3"));
        items.add(new Item(7L, "Samsung s22", 500000, "description 3"));
        items.add(new Item(8L, "Samsung s22", 80, "description 3"));
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void addItem(Item item) {
        item.setId(idCounter++);
        items.add(item);
    }

    public static Item getItemById(Long id) {
        for (Item item : items) {
            if (Objects.equals(item.getId(), id)) {
                return item;
            }
        }
        return null;
    }

    public static void removeItemById(Long id) {
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(items.get(i).getId(), id)) {
                items.remove(items.get(i));
            }
        }
    }

    public static void updateItem(Item item) {
        for (Item it : items) {
            if (Objects.equals(it.getId(), item.getId())) {
                items.remove(it);
            }
        }
    }

}
