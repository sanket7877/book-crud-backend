package com.example.bookcrud.repository;

import com.example.bookcrud.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query("SELECT a.id, a.name, COUNT(b.bookId) AS book_count,a.authorId FROM Author a LEFT JOIN Book b ON a.authorId = b.author GROUP BY a.authorId, a.name")
    List<Object[]> getAuthorBookCounts();
}
