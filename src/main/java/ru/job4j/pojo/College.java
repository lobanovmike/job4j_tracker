package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setName("Ivan Ivanovich Ivanov");
        ivan.setGroup(3);
        ivan.setDateOfEntrance(LocalDate.of(2021, 9, 1));
        String ln = System.lineSeparator();
        System.out.println("Name: " + ivan.getName()
                + ln + "Group: " + ivan.getGroup()
                + ln + "Date of Entrance: " + ivan.getDateOfEntrance());
    }
}
