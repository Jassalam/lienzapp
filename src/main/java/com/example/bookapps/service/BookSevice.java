/*package com.example.bookapps.service;

import com.example.bookapps.entity.Author;
import com.example.bookapps.entity.Book;
import com.example.bookapps.repositary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookSevice implements BookServiceI {
    @Autowired
    private BookRepository bookRepository;
    private AuthorService authorService;

    @Override
    public Book saveBook(Book book, Author author) {
        book.setId(book.getId());
        book.setName(book.getName());
        book.setAuthor(authorService.saveAuthor(author));
        return book;
    }

    @Override
    public Book createBook(Book book){
        bookRepository.save(book);
        return book;
    }
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        Book mybook = new Book();
        if (byId.isPresent()) {
            bookRepository.save(mybook);
        } else {
            throw new RuntimeException("No Book exist");
        }
        return mybook;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(book1 -> books.add(book1));
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).get();
        return book;
    }


}*/


