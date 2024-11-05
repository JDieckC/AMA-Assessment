package com.ama.agencybooks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ama.agencybooks.model.Book;
import com.ama.agencybooks.repository.BookRepository;
import com.ama.agencybooks.service.BookService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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

    @GetMapping("/books/user-books")
    public ResponseEntity<List<Book>> userBooks(@RequestHeader("x-user-id") long userId) {

        Optional<List<Book>> books = bookService.userClearedBooks(userId);

        //Normally I would expand on error messages to make it clearer to front end
        if(books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (books.get().isEmpty()) {

            //Making an assumption here that if no books where found, the user did not have clearance to see them
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(books.get(), HttpStatus.OK);

    }

}
