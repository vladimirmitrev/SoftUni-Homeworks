package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }

    @Override
    public List<String> printAllTitlesWithAgeRestriction(String ageRestriction) {

        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction.toUpperCase());

        return this.bookRepository.findByAgeRestriction(restriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printBooksWithEditionAndCopiesBelow(EditionType editionType, int copies) {

        return this.bookRepository.findByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> printTitlesAndPricesLowerAndHigher(float priceLower, float priceHigher) {

        BigDecimal lower = BigDecimal.valueOf(priceLower);
        BigDecimal higher = BigDecimal.valueOf(priceHigher);

        return this.bookRepository.findByPriceLessThanOrPriceGreaterThan(lower, higher);
    }

    @Override
    public List<String> printTitlesNotReleasedInInputYear(int releaseYear) {
            LocalDate before = LocalDate.of(releaseYear, 1, 1);
            LocalDate after = LocalDate.of(releaseYear, 12, 31);

        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before, after)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> printBooksReleasedBeforeDate(String date) {

        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate before = LocalDate.parse(date, formattedDate);

        return this.bookRepository.findAllByReleaseDateBefore(before);
    }

    @Override
    public List<String> printBookTitlesContaining(String letters) {

        return this.bookRepository.findByTitleContaining(letters)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> printBookTitleAndAuthorWithLastNameStartingWith(String letters) {

        return this.bookRepository.findByAuthorLastNameStartingWith(letters);
    }

    @Override
    public int printTheCountOfBooksWithTitleLongerThan(int inputNumber) {


        return this.bookRepository.countOfBooksWithTitleLongerThan(inputNumber);
    }

    @Override
    public List<Book> printBookTitleEditionTypeAgeRestrictionAndPrice(String givenTitle) {
        return this.bookRepository.findByTitle(givenTitle);
    }

    @Override
    public int increaseTheCopiesOfAllBooksReleasedAfterGvienDateWithGivenNumber(String date, int number) {

        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate dateAfter = LocalDate.parse(date, formattedDate);

        return this.bookRepository.countOfBooksIncreased(dateAfter, number);
    }

    @Override
    public int removeBooksWithCopiesLowerThan(int givenNumber) {
        return this.bookRepository.deleteBooksByCopiesLessThan(givenNumber);
    }

    @Override
    public int printTotalNumberOfBooksProcedure(String firstName, String lastName) {

        return this.bookRepository.totalCountOfBooksByAuthor(firstName, lastName);
    }


}
