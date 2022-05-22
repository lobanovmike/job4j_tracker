package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multyple(int y) {
        return y * x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multyple(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        result = Calculator.minus(15);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.divide(5);
        System.out.println(result);
        result = calculator.multyple(5);
        System.out.println(result);
        result = calculator.sumAllOperation(10);
        System.out.println(result);
    }
}