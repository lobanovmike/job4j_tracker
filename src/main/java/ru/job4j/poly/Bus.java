package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passenger(int count) {
        System.out.println("Количество пассажиров" + count);
    }

    @Override
    public double refuel(int count) {
        double priceOfLitre = 55;
        return count * priceOfLitre;
    }
}
