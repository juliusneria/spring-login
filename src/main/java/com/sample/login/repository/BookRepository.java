package com.sample.login.repository;

import com.sample.login.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by juliusneria on 18/10/2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    Book findByTitle(String title);
    /*Book findById(String id);
    Book deleteById(String id);*/
    List<Book> findByGenre(String genre);
}
