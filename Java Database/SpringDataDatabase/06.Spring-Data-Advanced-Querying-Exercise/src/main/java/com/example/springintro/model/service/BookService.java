package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);


    List<String > printAllTitlesWithAgeRestriction(String ageRestriction);

    List<String> printBooksWithEditionAndCopiesBelow(EditionType editionType, int copies);

    List<Book> printTitlesAndPricesLowerAndHigher(float priceLower, float priceHigher);

    List<String> printTitlesNotReleasedInInputYear(int year);

    List<Book> printBooksReleasedBeforeDate(String date);

    List<String> printBookTitlesContaining(String letters);

    List<Book> printBookTitleAndAuthorWithLastNameStartingWith(String letters);

    int printTheCountOfBooksWithTitleLongerThan(int inputNumber);

    List<Book> printBookTitleEditionTypeAgeRestrictionAndPrice(String givenTitle);

    int increaseTheCopiesOfAllBooksReleasedAfterGvienDateWithGivenNumber(String date, int number);

    int removeBooksWithCopiesLowerThan(int givenNumber);

    int printTotalNumberOfBooksProcedure(String firstName, String lastName);


}
