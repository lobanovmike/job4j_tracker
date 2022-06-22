package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenDuplicatePassportsThenFalse() {
        Citizen ivan = new Citizen("12345", "Ivan Ivanov");
        Citizen petr = new Citizen("12345", "Petr Petrov");
        PassportOffice office = new PassportOffice();
        office.add(ivan);
        assertFalse(office.add(petr));
    }
}