package com.bookpublisher.relationship.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String authorName;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();

    public Author() {
        super();
    }

    public Author(int authorId, String authorName, List<Book> books) {
        super();
        this.authorId = authorId;
        this.authorName = authorName;
        this.books = books;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
