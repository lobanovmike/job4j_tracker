package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска
     * @return Список подошедших пользователей
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> namePred = s -> s.getName().contains(key);
        Predicate<Person> surnamePred = s -> s.getSurname().contains(key);
        Predicate<Person> phonePred = s -> s.getPhone().contains(key);
        Predicate<Person> addressPred = s -> s.getAddress().contains(key);
        Predicate<Person> combine = namePred.or(surnamePred.or(phonePred.or(addressPred)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
