package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov.ivan@yandex.ru", "Ivanov Ivan");
        map.put("petrov.petr@yandex.ru", "Petrov Petr");
        map.put("sergeev.sergey@yandex.ru", "Sergeev Sergey");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
