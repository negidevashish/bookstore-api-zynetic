package com.devashish_book_store.bookstore.controller;

import com.devashish_book_store.bookstore.model.Book;
import com.devashish_book_store.bookstore.repository.BookRepository;
import com.devashish_book_store.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping
public ResponseEntity<List<Book>> getBooks(
        @RequestParam(required = false) String author,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Double rating
) {
    List<Book> books;

    if (author != null) {
        books = bookRepository.findByAuthor(author);
    } else if (category != null) {
        books = bookRepository.findByCategory(category);
    } else if (rating != null) {
        books = bookRepository.findByRatingGreaterThanEqual(rating);
    } else {
        books = bookRepository.findAll();
    }

    return ResponseEntity.ok(books);
}


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
public ResponseEntity<List<Book>> searchBooks(
        @RequestParam(required = false) String author,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Double rating,
        @RequestParam(required = false) String title
) {
    List<Book> results = bookService.searchBooks(author, category, rating, title);
    return ResponseEntity.ok(results);
}

}
