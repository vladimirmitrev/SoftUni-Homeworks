package com.example.bookshopsystem.repositories;

import com.example.bookshopsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    int countByReleaseDateAfter(LocalDate year2000);



    List<Book>  findByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle
            (String author_firstName, String author_lastName);

}
