package com.example.bookapps.controller;

import com.example.bookapps.entity.Author;

import com.example.bookapps.entity.Book;
import com.example.bookapps.repositary.AuthorRepository;
import com.example.bookapps.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    private Book book;


    @PostMapping()
    public Author create(@RequestBody Author author) {
        authorService.saveAuthor(author);
        List<Book> books= new ArrayList<>();
        for(Book bookIn : author.getBooks()){
            Book book = new Book();
            book.setId(bookIn.getId());
            book.setName(bookIn.getName());
            book.setAuthor(author);
            books.add(book);
        }
        author.setBooks(books);
        return authorService.saveAuthor(author);
    }

    @GetMapping
    public List<Author> all(){

        return authorService.findAllAuthor();
    }

    @GetMapping(value = "/{authorid}")
    public Author byId(@PathVariable Long authorid) {

        return authorService.findAuthorById(authorid);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

}
