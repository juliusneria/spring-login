package com.sample.login.controllers;

import com.sample.login.Book;
import com.sample.login.repository.BookRepository;
import com.sample.login.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by juliusneria on 18/10/2017.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/book") // This means URL's start with /demo (after Application path)
public class BookController {

    @Autowired
    private BranchRepository branch;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    Object addNewUser (@RequestBody Book book) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST
//        bookRepository.save(book);
        /*User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);*/
        return bookRepository.save(book);
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookRepository.findAll();
    }

    @GetMapping(path="/search")
    public @ResponseBody
    Object search(@RequestParam String category,
                  @RequestParam String value) {
        // This returns a JSON or XML with the users
        switch (category) {
            case "author":
                return bookRepository.findByAuthor(value);
            case "title":
                return bookRepository.findByTitle(value);
            case "genre":
                return bookRepository.findByGenre(value);
            default:
                return null;
        }
    }

    @PutMapping("/update")
    public @ResponseBody
    Object updateBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody
    Object delete(@PathVariable Long id) {
        // PUT processing
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.deleteById(id);

        return book;
    }

    /*@GetMapping(path="/search")
    public @ResponseBody Object getTitle(@RequestParam String title) {
        // This returns a JSON or XML with the users
        return bookRepository.findByTitle(title);
    }

    @GetMapping(path="/search")
    public @ResponseBody Object getGenre(@RequestParam String genre) {
        // This returns a JSON or XML with the users
        return bookRepository.findByGenre(genre);
    }*/


}