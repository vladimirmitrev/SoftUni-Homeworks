package com.example.bookshopsystem;

import com.example.bookshopsystem.entities.Author;
import com.example.bookshopsystem.entities.Book;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.repositories.BookRepository;
import com.example.bookshopsystem.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;    
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Todo uncomment to insert data
        this.seedService.seedAuthors();
        this.seedService.seedCategories();
        this.seedService.seedBooks();
//        this.seedService.seedAll();

        System.out.println();
        System.out.println("**********First Query**********");

        this.P01PrintAllBooksAfter2000();

        System.out.println();
        System.out.println("**********Second Query**********");

        this.P02PrintAllAuthorsWithBookBefore1990();

        System.out.println();
        System.out.println("**********Third Query**********");

        this.P03PrintAllAuthorsOrderedByCountOfBooks();

        System.out.println();
        System.out.println("**********Fourth Query**********");

        this.P04PrintAllBooksFromGivenName("George", "Powell");

        System.out.println();
    }


    private void P01PrintAllBooksAfter2000() {

        LocalDate year2000 = LocalDate.of(2000, 12, 31);

        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(year2000);

        books.forEach(book -> System.out.println(book.getTitle()));

        int booksCount = this.bookRepository.countByReleaseDateAfter(year2000);

        System.out.printf("Total books %d%n", booksCount);
    }

    private void P02PrintAllAuthorsWithBookBefore1990() {

        LocalDate year1990 = LocalDate.of(1990, 01, 01);

        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(author ->
                System.out.printf("%s %s%n", author.getFirstName(), author.getLastName()));

    }

    private void P03PrintAllAuthorsOrderedByCountOfBooks() {

        List<Author> authors = this.authorRepository.findAll();

        authors.stream()
                .sorted((left, right) -> right.getBooks().size() - left.getBooks().size())
                .forEach(author -> {
                    System.out.printf("%s %s -> %d%n",
                            author.getFirstName(),
                            author.getLastName(),
                            author.getBooks().size());
                });
    }

    private void P04PrintAllBooksFromGivenName(String firstName, String lastName) {
        List<Book> books = bookRepository.
                findByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName);

        books.forEach(book -> System.out.printf("%s %s %d%n",
                book.getTitle(), book.getReleaseDate(), book.getCopies()));


        //Prettier printing
//        books.forEach(book -> System.out.printf("Book title:'%s' Release Date:[%s] Total Copies:[%d]%n",
////                book.getTitle(), book.getReleaseDate(), book.getCopies()));

    }
}
