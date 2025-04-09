package com.devashish_book_store.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<String> getBooks() {
        return List.of("Book 1", "Book 2", "Book 3");
    }
}
