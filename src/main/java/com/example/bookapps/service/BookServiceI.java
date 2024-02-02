package com.example.bookapps.service;

import com.example.bookapps.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceI {
     Book saveBook(Book book);

    public void deleteBook(Long id);

    Book updateBook(Long id);
   Optional<Book> getBookById(Long id);
   List<Book> getAllBooks();

   List<Book> findBookByName(String name);

   List<Book> findBookByAuthorId(Long id);
}
