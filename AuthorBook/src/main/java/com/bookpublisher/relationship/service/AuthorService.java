package com.bookpublisher.relationship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.repository.AuthorRepository;
import com.bookpublisher.relationship.repository.BookRepository;



@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    // Get all authors
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    // Get author by ID
    public Author getAuthor(int authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }

    // Add new author with existing books
    public Author addAuthor(Author author) {
        List<Integer> bookIds = new ArrayList<>();
        for (Book book : author.getBooks()) {
            bookIds.add(book.getBookId());
        }

        try {
            List<Book> completeBooks = bookRepository.findAllById(bookIds);
            if (bookIds.size() != completeBooks.size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more book IDs are invalid");
            }

            author.setBooks(completeBooks);
            for (Book b : completeBooks) {
                b.getAuthors().add(author);
            }

            return authorRepository.save(author);

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book IDs");
        }
    }

    // Update author details
    public Author updateAuthor(int authorId, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));

        List<Integer> bookIds = new ArrayList<>();
        for (Book book : updatedAuthor.getBooks()) {
            bookIds.add(book.getBookId());
        }

        List<Book> completeBooks = bookRepository.findAllById(bookIds);
        if (bookIds.size() != completeBooks.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more book IDs are invalid");
        }

        for (Book b : completeBooks) {
            b.getAuthors().add(existingAuthor);
        }

        existingAuthor.setBooks(completeBooks);
        existingAuthor.setAuthorName(updatedAuthor.getAuthorName());
        return authorRepository.save(existingAuthor);
    }

    // Delete author
    public void deleteAuthor(int authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));

        List<Book> books = author.getBooks();
        for (Book book : books) {
            book.getAuthors().remove(author);
        }
        bookRepository.saveAll(books);
        authorRepository.deleteById(authorId);
    }

    // Get all books by an author
    public List<Book> getAuthorBooks(int authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
        return author.getBooks();
    }
}
