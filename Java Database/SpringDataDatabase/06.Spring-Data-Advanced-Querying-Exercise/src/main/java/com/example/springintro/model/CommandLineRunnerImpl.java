package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
//          Problems from 05.Spring-Data-Intro-Exercise

//          seedData();
//          printAllBooksAfterYear(2000);
//          printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//          printAllAuthorsAndNumberOfTheirBooks();
//          printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        Scanner scanner = new Scanner(System.in);

//        06.Spring-Data-Advanced-Querying-Exercise

        // Todo: Uncomment problem number to test method

//        p01PrintBooksTitlesByAgeRestriction(scanner);

//        p02PrintBooksWithEditionTypeGOLDAndCopiesBelow5000();

//        p03PrintTitlesWithPricesLowerOrHigher();

//        p04PrintTitlesNotReleasedInInputYear(scanner);

//        p05PrintBooksReleasedBeforeDate(scanner);

//        p06PrintAuthorNamesWhichFirstNameEndsWith(scanner);

//        p07PrintBookTitlesContaining(scanner);

//        p08PrintBookTitleAndAuthorWithLastNameStartingWith(scanner);

//        p09PrintTheCountOfBooksWithTitleLongerThan(scanner);

//        P10PrintAuthorsWithTotalCopies();

//        p11PrintBookTitleEditionTypeAgeRestrictionAndPrice(scanner);

//        p12IncreaseTheCopiesOfAllBooksReleasedAfterGivenDateWithGivenNumber(scanner);

//        p13RemoveBooksWithCopiesLowerThan(scanner);

//        p14PrintTotalBooksByAuthorWithProcedure(scanner);

    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void p01PrintBooksTitlesByAgeRestriction(Scanner scanner) {
        String ageRestriction = scanner.nextLine();

        this.bookService.printAllTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);

    }

    private void p02PrintBooksWithEditionTypeGOLDAndCopiesBelow5000() {
        this.bookService.printBooksWithEditionAndCopiesBelow(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void p03PrintTitlesWithPricesLowerOrHigher() {
        float priceLower = 4;
        float priceHigher = 40;

        this.bookService.printTitlesAndPricesLowerAndHigher(priceLower, priceHigher)
                .forEach(book -> System.out.printf("%s - $%.2f%n", book.getTitle(), book.getPrice()));
    }

    private void p04PrintTitlesNotReleasedInInputYear(Scanner scanner) {
        int year = Integer.parseInt(scanner.nextLine());

        this.bookService.printTitlesNotReleasedInInputYear(year)
                .forEach(System.out::println);
    }

    private void p05PrintBooksReleasedBeforeDate(Scanner scanner) {
        String date = scanner.nextLine();

        this.bookService.printBooksReleasedBeforeDate(date)
                .forEach(book -> System.out.printf("%s %s %.2f%n",
                        book.getTitle(), book.getEditionType(), book.getPrice()));
    }

    private void p06PrintAuthorNamesWhichFirstNameEndsWith(Scanner scanner) {
        String letters = scanner.nextLine();

        this.authorService.printAuthorNamesWhichFirstNameEndsWith(letters)
                .forEach(author -> System.out.printf("%s %s%n",
                        author.getFirstName(), author.getLastName()));
    }

    private void p07PrintBookTitlesContaining(Scanner scanner) {
        String letters = scanner.nextLine();

        this.bookService.printBookTitlesContaining(letters)
                .forEach(System.out::println);
    }

    private void p08PrintBookTitleAndAuthorWithLastNameStartingWith(Scanner scanner) {
        String letters = scanner.nextLine();

        this.bookService.printBookTitleAndAuthorWithLastNameStartingWith(letters)
                .forEach(book -> System.out.printf("%s (%s %s)%n",
                        book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName()));
    }

    private void p09PrintTheCountOfBooksWithTitleLongerThan(Scanner scanner) {
        int inputNumber = Integer.parseInt(scanner.nextLine());

        int countOfBooks = this.bookService.printTheCountOfBooksWithTitleLongerThan(inputNumber);

        System.out.printf("There are %d books with longer titles than %d symbols.%n", countOfBooks, inputNumber);
    }

    private void P10PrintAuthorsWithTotalCopies() {
        this.authorService.printAuthorsAndTotalBookCopies()
                .forEach(a -> System.out.printf("%s %s - %d%n", a.getFirstNam(),a.getLastNam(),a.getTotalCopies()));
    }

    private void p11PrintBookTitleEditionTypeAgeRestrictionAndPrice(Scanner scanner) {
        String givenTitle = scanner.nextLine();

        this.bookService.printBookTitleEditionTypeAgeRestrictionAndPrice(givenTitle)
                .forEach(book -> System.out.printf("%s %s %s %.2f%n",
                        book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice()));
    }
    private void p12IncreaseTheCopiesOfAllBooksReleasedAfterGivenDateWithGivenNumber(Scanner scanner) {
        String date = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());

        int totalBooksUpdated = this.bookService.increaseTheCopiesOfAllBooksReleasedAfterGvienDateWithGivenNumber(date, number);

        System.out.printf("%d books are released after %s, so a total of %d book copies were added.",
                totalBooksUpdated, date, totalBooksUpdated * number);
    }

    private void p13RemoveBooksWithCopiesLowerThan(Scanner scanner) {
        int givenNumber = Integer.parseInt(scanner.nextLine());

        int deletedBooks = this.bookService.removeBooksWithCopiesLowerThan(givenNumber);

        System.out.printf("Total %d books were deleted%n", deletedBooks);
    }
    private void p14PrintTotalBooksByAuthorWithProcedure(Scanner scanner) {

        //make a procedure in database
        //SQL queries file path is "src\main\resources\files\SQLQueries.sql"

        String[] authorName = scanner.nextLine().split(" ");
        int totalCountOfBooks =
                this.bookService.printTotalNumberOfBooksProcedure(authorName[0], authorName[1]);

        System.out.printf("%s %s has written %d books%n",
                authorName[0], authorName[1], totalCountOfBooks);
    }
}
