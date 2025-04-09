package com.devashish_book_store.bookstore.repository;

import com.devashish_book_store.bookstore.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);

    List<Book> findByCategory(String category);

    List<Book> findByRatingGreaterThanEqual(double rating);
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByCategoryContainingIgnoreCase(String category);
    List<Book> findByRatingGreaterThanEqual(Double rating);
    List<Book> findByTitleContainingIgnoreCase(String title);
}
