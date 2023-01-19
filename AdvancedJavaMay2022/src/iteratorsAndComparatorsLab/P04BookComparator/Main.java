package iteratorsAndComparatorsLab.P04BookComparator;

import iteratorsAndComparatorsLab.P01Book.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookFour = new Book("Harry Potter", 1982, "J.K. Rowling");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        books.add(bookFour);

//        books.stream()
//                .sorted(new BookComparator())
//                .forEach(System.out::println);
//
//        TreeSet order by Year

//        TreeSet<Book> setOfBooks = new TreeSet<>(new BookComparatorByYear());
//        setOfBooks.add(bookOne);
//        setOfBooks.add(bookTwo);
//        setOfBooks.add(bookThree);
//        setOfBooks.add(bookFour);
//
//        for (Book setOfBook : setOfBooks) {
//            System.out.println(setOfBook);
//        }

//         //1 variant by Year
        books.stream().sorted(new BookComparatorByYear())
                .forEach(System.out::println);
//            //2 variant Year
//        books.stream().sorted(Comparator.comparingInt(Book::getYear))
//                .forEach(System.out::println);

//        books.sort(new BookComparator());

//        for (Book book : books) {
//            System.out.println(book.getTitle() + " " + book.getYear());
//        }

//        Comparing by Authors
//        books.stream().sorted(Comparator.comparingInt(b -> b.getAuthors().size()))
//                .forEach(System.out::println);

//            by Authors reversed
//
//        books.stream().sorted((f, s ) -> Integer.compare(s.getAuthors().size(), f.getAuthors().size()))
//                .forEach(System.out::println);


    }
}
