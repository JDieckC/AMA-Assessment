package com.ama.agencybooks.controller;

import org.springframework.web.bind.annotation.RestController;
import com.ama.agencybooks.model.Book;
import com.ama.agencybooks.repository.BookRepository;
import com.ama.agencybooks.service.BookService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BooksController {

    private BookService bookService;
    private BookRepository bookRepo;

    public BooksController(BookService bookService, BookRepository bookRepo) {
        this.bookService = bookService;
        this.bookRepo = bookRepo;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/books/{bookId}")
    public Optional<Book> getBook(@RequestParam Long bookId) {
        return bookService.getBook(bookId);
    }
    
    @GetMapping("/books/top_secret")
    public List<String> getSecretBooksList() {
        return Arrays.asList("Foo", "Bar");
    }
    
    @PostMapping("/books")
    public Book addBook(@RequestBody Book newBook) {
        return bookRepo.save(newBook);
    }
}
