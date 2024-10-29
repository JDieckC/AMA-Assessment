package com.ama.agencybooks.service;

import com.ama.agencybooks.model.Book;
import com.ama.agencybooks.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepo;
    
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBook(Long bookId) {
            return bookRepo.findById(bookId);
        }

}