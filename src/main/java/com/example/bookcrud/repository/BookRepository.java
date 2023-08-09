package com.example.bookcrud.repository;

import com.example.bookcrud.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByAuthorAuthorId(Integer authorId);

    void deleteBookByBookId(Integer id);
}
