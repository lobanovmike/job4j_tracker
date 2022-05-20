package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error unknownError = new Error();
        Error error404 = new Error(true, 404, "Not found");
        Error error500 = new Error(true, 500, "Internal server error");
        unknownError.printInfo();
        error404.printInfo();
        error500.printInfo();
    }
}
