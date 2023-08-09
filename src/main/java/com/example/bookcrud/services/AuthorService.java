package com.example.bookcrud.services;

import com.example.bookcrud.model.Author;
import com.example.bookcrud.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public int addAuthor(Author author){
        Author res = authorRepository.save(author);
        return res.getAuthorId();
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Object[]> getAuthorBookCounts() {
        return authorRepository.getAuthorBookCounts();
    }
}
