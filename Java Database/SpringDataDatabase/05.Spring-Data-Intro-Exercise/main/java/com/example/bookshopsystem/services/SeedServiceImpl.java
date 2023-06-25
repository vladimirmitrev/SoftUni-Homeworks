package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.*;
import com.example.bookshopsystem.repositories.AuthorRepository;
import com.example.bookshopsystem.repositories.BookRepository;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final String RESOURCES_PATH = "src\\main\\resources\\files";


    private static final String AUTHORS_FILE_NAME = RESOURCES_PATH + "\\authors.txt";
    private static final String CATEGORIES_FILE_NAME = RESOURCES_PATH + "\\categories.txt";
    private static final String BOOKS_FILE_NAME = RESOURCES_PATH + "\\books.txt";

    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    private final BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public SeedServiceImpl(AuthorRepository authorRepository, CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> s.split(" "))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(this::getBookObject)
                .forEach(bookRepository::save);
    }

    private Book getBookObject(String line) {

        String[] bookParts = line.split(" ");

        int editionTypeIndex = Integer.parseInt(bookParts[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];

        LocalDate releaseDate = LocalDate.parse(bookParts[1],
                DateTimeFormatter.ofPattern("d/M/yyyy"));

        int copies = Integer.parseInt(bookParts[2]);

        BigDecimal price = new BigDecimal(bookParts[3]);

        AgeRestriction ageRestriction =
                AgeRestriction.values()[Integer.parseInt(bookParts[4])];

        String title = Arrays.stream(bookParts)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();

        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(title, editionType, price, copies,
                releaseDate, ageRestriction, author, categories);
    }
}

