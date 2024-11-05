package com.ama.agencybooks.service;

import com.ama.agencybooks.model.Book;
import com.ama.agencybooks.model.SecurityLevel;
import com.ama.agencybooks.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepo;
    private BookSearchService bookSearch;
    
    public BookService(BookRepository bookRepo, BookSearchService bookSearch) {
        this.bookRepo = bookRepo;
        this.bookSearch = bookSearch;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBook(Long bookId) {
            return bookRepo.findById(bookId);
        }

    public Optional<List<Book>> userClearedBooks(long userId) {
        Optional<SecurityLevel> userSecurity = bookSearch.getUserClearance(userId);

        if (userSecurity.isEmpty()) {
            return Optional.empty();
        }

        //With more time I would have created a custom query that only retrieves books
        //to which the user had clearance for and called with
        //return bookRepo.findBooksByClearance();

        List<Book> books = bookRepo.findAll();

        return getClearedBooks(books, userSecurity.get());
    }

    private Optional<List<Book>> getClearedBooks(List<Book> books, SecurityLevel securityLevel) {
        List<Book> clearedBooks = new ArrayList<>();

        //Not the best way to check for books
        //With more time I would build a hierarchy of clearance in a database readable way
        //then query for every book that equals or is below the user clearance
        for (Book book : books) {
            if(securityLevel == SecurityLevel.TOP_SECRET
            || book.getClassification() == SecurityLevel.UNCLASSIFIED) {
                clearedBooks.add(book);
            }
        }

        return Optional.of(clearedBooks);
    }

}