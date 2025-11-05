package com.bookpublisher.relationship.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String bookName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "bookId"),
        inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(int bookId, String bookName, List<Author> authors) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.authors = authors;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
