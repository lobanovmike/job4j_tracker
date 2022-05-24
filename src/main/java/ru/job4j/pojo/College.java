package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setName("Ivan Ivanovich Ivanov");
        ivan.setGroup(3);
        ivan.setDateOfEntrance(LocalDate.of(2021, 9, 1));
        System.out.println("Name: " + ivan.getName()
                + "\nGroup: " + ivan.getGroup()
                + "\nDate of Entrance: " + ivan.getDateOfEntrance());
    }
}
