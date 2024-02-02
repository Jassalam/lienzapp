package com.example.bookapps.repositary;

import com.example.bookapps.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteById(Optional<Book> byId);

    List<Book> findBookByName(@Param("name") String name);

}
