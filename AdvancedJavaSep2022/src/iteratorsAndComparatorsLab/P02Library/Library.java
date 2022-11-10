package iteratorsAndComparatorsLab.P02Library;

import iteratorsAndComparatorsLab.P01Book.Book;

import java.util.Arrays;
import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;

    }

    @Override
    public Iterator<Book> iterator() {
        return Arrays.stream(books).iterator();
    }
}
