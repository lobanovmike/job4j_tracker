package ru.job4j.poly;

public interface Transport {
    void drive();

    void passenger(int count);

    double refuel(int count);
}
