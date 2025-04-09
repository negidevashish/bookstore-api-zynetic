package com.devashish_book_store.bookstore.controller;

import com.devashish_book_store.bookstore.dto.LoginResponse;
import com.devashish_book_store.bookstore.jwt.JwtUtil;
import com.devashish_book_store.bookstore.model.User;
import com.devashish_book_store.bookstore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserRepository userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return "Email already registered";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User registered";
    }

    

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(userDetails.getUsername()); // userDetails.getUsername() returns the email
            
            return new LoginResponse(token);

        } catch (BadCredentialsException e) {
        throw new RuntimeException("Invalid credentials");
        }
    }
}
