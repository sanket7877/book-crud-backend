package com.example.bookcrud.controller;

import com.example.bookcrud.dto.AuthorReq;
import com.example.bookcrud.model.Author;
import com.example.bookcrud.payload.ApiResponse;
import com.example.bookcrud.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorReq req){
        Author author=new Author();
        author.setId(req.getAuthorId());
        author.setName(req.getAuthorName());
        int res = authorService.addAuthor(author);
        boolean status =res>0?true:false;
        return  ResponseEntity.ok(new ApiResponse(null,status,res>0?"Author added Successfully":"Operation Failed"));
    }

    @GetMapping("/get-all-authors")
    public List<Author> findAllAuthor(){
        return authorService.findAllAuthors();
    }

    @GetMapping("/bookCounts")
    public List<Object[]> getAuthorBookCounts() {
        return authorService.getAuthorBookCounts();
    }
}
