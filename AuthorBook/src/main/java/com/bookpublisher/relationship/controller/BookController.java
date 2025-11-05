package com.bookpublisher.relationship.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.service.BookService;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all books
    @GetMapping("/getbooks")
    public List<Book> getBooks() {
        return bookService.getAll();
    }

    // Get book by ID
    @GetMapping("/getbook/{bookid}")
    public Optional<Book> getBookById(@PathVariable int bookid) {
        return bookService.getById(bookid);
    }

    // Add new book with existing author references
    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Update book details
    @PutMapping("/updatebook/{bookid}")
    public Book updateBook(@PathVariable int bookid, @RequestBody Book newBook) {
        return bookService.updateBook(bookid, newBook);
    }

    // Delete book
    @DeleteMapping("/deletebook/{bookid}")
    public void deleteBook(@PathVariable int bookid) {
        bookService.deleteBook(bookid);
    }

    // Get all authors of a book
    @GetMapping("/getbook/{bookid}/authors")
    public List<Author> getBookAuthors(@PathVariable int bookid) {
        return bookService.getBookAuthors(bookid);
    }
}
