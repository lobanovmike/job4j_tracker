package ru.job4j.oop;

import ru.job4j.oop.Ball;
import ru.job4j.oop.Fox;
import ru.job4j.oop.Hare;
import ru.job4j.oop.Wolf;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
    }
}
