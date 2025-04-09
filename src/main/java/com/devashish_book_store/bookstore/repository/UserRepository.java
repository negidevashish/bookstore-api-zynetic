package com.devashish_book_store.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devashish_book_store.bookstore.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    
}
