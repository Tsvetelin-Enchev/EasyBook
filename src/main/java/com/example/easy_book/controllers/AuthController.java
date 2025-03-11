package com.example.easy_book.controllers;

import com.example.easy_book.services.UserService;
import com.example.easy_book.utils.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "Login successful!";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        userService.registerUser(request);
        return "User registered successfully!";
    }
}
