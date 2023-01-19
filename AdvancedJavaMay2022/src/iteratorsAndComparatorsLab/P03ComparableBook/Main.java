package iteratorsAndComparatorsLab.P03ComparableBook;


import iteratorsAndComparatorsLab.P01Book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookFour = new Book("Harry Potter", 1982, "J.K. Rowling");

//        List<Book> bookList = new ArrayList<>();
//
//        bookList.add(bookOne);
//        bookList.add(bookTwo);
//        bookList.add(bookThree);
//        bookList.add(bookFour);
//
//        bookList.stream().sorted().forEach(System.out::println);

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.println(String.format("%s is before %s", bookOne, bookTwo));
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format("%s is before %s", bookTwo, bookOne));
        } else {
            System.out.println("Book are equal");
        }
    }
}

