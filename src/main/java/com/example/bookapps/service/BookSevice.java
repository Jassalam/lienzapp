package com.example.bookapps.service;

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
    @Autowired
    private AuthorService authorService;

    @Override
    public Book saveBook(Book book) {
        book.setId(book.getId());
        book.setName(book.getName());
        book.setAuthor(book.getAuthor());
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
        return new ArrayList<Book>(bookRepository.findAll());
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    @Override
    public List<Book> findBookByAuthorId(Long id) {
        return null;


    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);

    }


}


