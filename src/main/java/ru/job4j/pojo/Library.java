package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Alghoritms", 700);
        books[1] = new Book("Design patterns", 500);
        books[2] = new Book("Java", 1500);
        books[3] = new Book("Clean code", 600);
        for (Book book : books) {
            System.out.println(book.getName() + ": " + book.getPageCount());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book book : books) {
            System.out.println(book.getName() + ": " + book.getPageCount());
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ": " + book.getPageCount());
            }
        }

    }
}
