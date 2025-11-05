package com.bookpublisher.relationship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.repository.AuthorRepository;
import com.bookpublisher.relationship.repository.BookRepository;



@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Get all books
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getById(int bookId) {
        return bookRepository.findById(bookId);
    }

    // Add new book with existing authors
    public Book addBook(Book book) {
        List<Integer> authorIds = new ArrayList<>();
        for (Author author : book.getAuthors()) {
            authorIds.add(author.getAuthorId());
        }

        try {
            List<Author> completeAuthors = authorRepository.findAllById(authorIds);
            if (authorIds.size() != completeAuthors.size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more author IDs are invalid");
            }

            book.setAuthors(completeAuthors);
            for (Author a : completeAuthors) {
                a.getBooks().add(book);
            }

            return bookRepository.save(book);

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid author IDs");
        }
    }

    // Update existing book
    public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        List<Integer> authorIds = new ArrayList<>();
        for (Author author : updatedBook.getAuthors()) {
            authorIds.add(author.getAuthorId());
        }

        List<Author> completeAuthors = authorRepository.findAllById(authorIds);
        if (authorIds.size() != completeAuthors.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more author IDs are invalid");
        }

        for (Author a : completeAuthors) {
            a.getBooks().add(existingBook);
        }

        existingBook.setAuthors(completeAuthors);
        existingBook.setBookName(updatedBook.getBookName());
        return bookRepository.save(existingBook);
    }

    // Delete book
    public void deleteBook(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            author.getBooks().remove(book);
        }

        authorRepository.saveAll(authors);
        bookRepository.deleteById(bookId);
    }

    // Get all authors for a book
    public List<Author> getBookAuthors(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return book.getAuthors();
    }
}
