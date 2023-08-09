package com.example.bookcrud.services;

import com.example.bookcrud.dto.BookReq;
import com.example.bookcrud.model.Author;
import com.example.bookcrud.model.Book;
import com.example.bookcrud.model.Category;
import com.example.bookcrud.payload.ApiResponse;
import com.example.bookcrud.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public ApiResponse addBook(BookReq req){
        Book book=new Book();
        if(req.isEdit()){
            book.setBookId(req.getBookId());
        }
        book.setTitle(req.getTitle());
        book.setDescription(req.getDescription());
        Category category=new Category();
        category.setCategoryId(req.getCategoryId());
        book.setCategory(category);
        Author author=new Author();
        author.setAuthorId(req.getAuthorId());
        book.setAuthor(author);
        book.setReleaseDate(req.getReleaseData());

        Book res = bookRepository.save(book);

        return new ApiResponse(null, res.getBookId() > 0,res.getBookId()>0?"Book Added":"failed operations");
    }


    public List<Book> findBooksByAuthorId(Integer authorId) {
        return bookRepository.findByAuthorAuthorId(authorId);
    }

    @Transactional
    public ApiResponse deleteBookById(Integer id){
        bookRepository.deleteBookByBookId(id);
        return new ApiResponse(null, true,"Books deleted sussessfully");
    }

    public Optional<Book> findByBookId(Integer id){
        return bookRepository.findById(id);
    }
}
