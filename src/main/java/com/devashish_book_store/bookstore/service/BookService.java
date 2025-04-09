package com.devashish_book_store.bookstore.service;

import com.devashish_book_store.bookstore.model.Book;
import com.devashish_book_store.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> updateBook(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setCategory(book.getCategory());
            existingBook.setPrice(book.getPrice());
            existingBook.setRating(book.getRating());
            existingBook.setPublishedDate(book.getPublishedDate());
            return bookRepository.save(existingBook);
        });
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String author, String category, Double rating, String title) {
        List<Book> results = bookRepository.findAll();
    
        if (author != null && !author.isEmpty()) {
            results.retainAll(bookRepository.findByAuthorContainingIgnoreCase(author));
        }
    
        if (category != null && !category.isEmpty()) {
            results.retainAll(bookRepository.findByCategoryContainingIgnoreCase(category));
        }
    
        if (rating != null) {
            results.retainAll(bookRepository.findByRatingGreaterThanEqual(rating));
        }
    
        if (title != null && !title.isEmpty()) {
            results.retainAll(bookRepository.findByTitleContainingIgnoreCase(title));
        }
    
        return results;
    }
    
}
