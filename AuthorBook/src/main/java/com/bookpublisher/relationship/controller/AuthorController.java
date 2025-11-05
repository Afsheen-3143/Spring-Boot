package com.bookpublisher.relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.service.AuthorService;


@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Get all authors
    @GetMapping("/getauthors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    // Get author by ID
    @GetMapping("/getauthor/{authorid}")
    public Author getAuthor(@PathVariable int authorid) {
        return authorService.getAuthor(authorid);
    }

    // Add new author with existing book references
    @PostMapping("/addauthor")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    // Update author details
    @PutMapping("/updateauthor/{authorid}")
    public Author updateAuthor(@PathVariable int authorid, @RequestBody Author newAuthor) {
        return authorService.updateAuthor(authorid, newAuthor);
    }

    // Delete author
    @DeleteMapping("/deleteauthor/{authorid}")
    public void deleteAuthor(@PathVariable int authorid) {
        authorService.deleteAuthor(authorid);
    }

    // Get all books written by an author
    @GetMapping("/getauthor/{authorid}/books")
    public List<Book> getAuthorBooks(@PathVariable int authorid) {
        return authorService.getAuthorBooks(authorid);
    }
}
