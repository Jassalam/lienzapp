package com.example.bookapps.controller;

import com.example.bookapps.entity.Author;

import com.example.bookapps.entity.Book;
import com.example.bookapps.repositary.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    private Book book;


    @PostMapping()
    public Author create(@RequestBody Author author) {
        authorRepository.save(author);
        List<Book> books= new ArrayList<>();
        for(Book bookIn : author.getBooks()){
            Book book = new Book();
            book.setId(bookIn.getId());
            book.setName(bookIn.getName());
            book.setAuthor(author);
            books.add(book);
        }
        author.setBooks(books);
        Author saveAuthor = authorRepository.save(author);
        return saveAuthor;

    }

    @GetMapping
    public Iterable<Author> all(){
        return authorRepository.findAll();
    }

    @GetMapping(value = "/{authorid}")
    public Author byId(@PathVariable Long authorid) {

        return authorRepository.findById(authorid).get();
    }

}
