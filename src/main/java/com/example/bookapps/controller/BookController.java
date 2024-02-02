package com.example.bookapps.controller;

import com.example.bookapps.entity.Book;
import com.example.bookapps.repositary.AuthorRepository;
import com.example.bookapps.repositary.BookRepository;
import com.example.bookapps.service.AuthorService;
import com.example.bookapps.service.BookSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookSevice bookSevice;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    private List<Book> getAllBook(){
        return bookSevice.getAllBooks();
    }

    @GetMapping("/{id}")
    private Optional<Book> getBookById(@PathVariable(value = "id") Long id){
        return bookSevice.getBookById(id);
    }

   @DeleteMapping("/{id}")
   private void deleteBook(@PathVariable("id") Long id){

        bookSevice.deleteBook(id);
   }

   @PostMapping()
    private Book saveBook(@RequestBody Book book){
       return bookSevice.saveBook(book);
   }

   @PutMapping("/{id}")
    private Optional<Book> updateBook(@PathVariable("id") Long id){
       Optional<Book> byId = bookSevice.getBookById(id);
       Book mybook = new Book();
       if (byId.isPresent()) {
           bookSevice.saveBook(mybook);
       } else {
           throw new RuntimeException("No Book exist");
       }
       return Optional.of(mybook);
    }




    @GetMapping(value = "/{name}")
    public  List<Book> allBookWithBookName(@PathVariable String name){
        return bookSevice.findBookByName(name);
    }

  }

