package com.example.bookcrud.controller;


import com.example.bookcrud.dto.BookReq;
import com.example.bookcrud.payload.ApiResponse;
import com.example.bookcrud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody BookReq req){
        return  ResponseEntity.ok(bookService.addBook(req));
    }

    @GetMapping("/get-author-books/{id}")
    public ResponseEntity<?>  getAuthorBooks(@PathVariable("id") Integer id) {
        return  ResponseEntity.ok(bookService.findBooksByAuthorId(id));
    }

    @DeleteMapping("/delete-boook-by-id/{id}")
    public ResponseEntity<?>  deleteBooksById(@PathVariable("id") Integer id) {
        return  ResponseEntity.ok(bookService.deleteBookById(id));
    }

    @GetMapping("/find-by-book/{id}")
    public ResponseEntity<?>  findByBookId(@PathVariable("id") Integer id) {
        return  ResponseEntity.ok(bookService.findByBookId(id));
    }
}
