/*package com.example.bookapps.service;

import com.example.bookapps.entity.Author;
import com.example.bookapps.entity.Book;
import com.example.bookapps.repositary.AuthorRepository;
import com.example.bookapps.repositary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public Author saveAuthor(Author author){
        authorRepository.save(author);
        List<Book> books= new ArrayList<>();
        for(Book bookIn : author.getBookList()){
            Book book = new Book(bookIn.getName(), bookIn.getId());
            book.setAuthor(author);
            books.add(book);
        }

        return author;
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }


    public Author findAuthorById(Long id){
        Author author = authorRepository.findById(id).get();
        return author;
    }


    public List<Author> findAllAuthors(){
        List<Author> authors = new ArrayList<Author>();
        authorRepository.findAll().forEach(author -> authors.add(author));
        return authors;
    }
}*/
