package com.example.bookapps.controller;

import com.example.bookapps.entity.Book;
import com.example.bookapps.repositary.AuthorRepository;
import com.example.bookapps.repositary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    private List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Book> getBookById(@PathVariable("id") Long id){
        return bookRepository.findById(id);
    }

   @DeleteMapping("/{id}")
   private void deleteBook(@PathVariable("id") Long id){

        bookRepository.deleteById(id);
   }

   @PostMapping()
    private Book saveBook(@RequestBody Book book){
       return bookRepository.save(book);
   }

   @PutMapping("/{id}")
    private Optional<Book> updateBook(@PathVariable("id") Long id){
       Optional<Book> byId = bookRepository.findById(id);
       Book mybook = new Book();
       if (byId.isPresent()) {
           bookRepository.save(mybook);
       } else {
           throw new RuntimeException("No Book exist");
       }
       return Optional.of(mybook);
    }



    @GetMapping(value = "/author/{authorid}")
    public List<Book> allBookForAuthor(@PathVariable Long authorid){

        return authorRepository.findById(authorid).isPresent() ? authorRepository.findById(authorid).get().getBooks() : new ArrayList<>();
    }

    @GetMapping(value = "/{bookname}")
    public  List<Book> allBookWithBookName(@PathVariable String bookname){
        return bookRepository.findAllByNameIgnoreCase(bookname);
    }

  }

