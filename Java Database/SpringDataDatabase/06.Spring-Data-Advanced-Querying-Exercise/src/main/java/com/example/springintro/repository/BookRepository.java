package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findByTitleContaining(String letters);


    List<Book> findByAuthorLastNameStartingWith(String letters);

    @Query("SELECT COUNT(b) FROM Book b " +
            "WHERE LENGTH(b.title) > :length")
    int countOfBooksWithTitleLongerThan(int length);

    List<Book> findByTitle(String givenTitle);


    @Modifying
    @Transactional
    @Query("UPDATE Book b " +
            "SET b.copies = b.copies + :number "+
            "WHERE b.releaseDate > :dateAfter ")
    int countOfBooksIncreased(LocalDate dateAfter, int number);

    @Transactional
    int deleteBooksByCopiesLessThan(int givenNumber);

    @Procedure("udp_total_amount_of_books_the_author_has_written")
    int totalCountOfBooksByAuthor(String firstName, String lastName);
}
