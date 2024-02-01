package com.example.bookapps.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "author")
public class Author {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(name = "author_name")
     private String authorName;

     @Column(name = "author_email")
     private String authorEmail;

   /* @OneToMany
    @JoinTable(name="book", joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns=@JoinColumn(name="author_id"))
    private List<Book> books = new ArrayList<>();*/

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;


    public Author() {
        super();
    }

    public Author(Long id, String authorName, String authorEmail) {
        this.id = id;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
