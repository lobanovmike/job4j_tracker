package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя сервиса банка
 * @author Mikhail Lobanov
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя
     */
    private String passport;
    /**
     * ФИО пользователя
     */
    private String username;

    /**
     * Конструктор принимает паспорт и ФИО пользователя
     * @param passport паспорт пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспорт пользователя
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает паспорт и устанавливает его для пользователя
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО пользователя
     * @return ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает ФИО и устанавливает его для пользователя
     * @param username ФИО пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

}
