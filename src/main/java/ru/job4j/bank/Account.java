package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Mikhail Lobanov
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета хранятся в переменной типа String
     */
    private String requisite;
    /**
     * Баланс счета хранится в переменной типа double
     */
    private double balance;

    /**
     * Конструктор принимает реквизиты нового счета и его начальный баланс
     * @param requisite реквизиты счета
     * @param balance баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
      * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает реквизиты и устанавливает их для текущего счета
     * @param requisite реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает баланс и устанавливает его для текущего счета
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

}
