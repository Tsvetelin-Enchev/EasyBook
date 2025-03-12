package com.example.easy_book.controllers;

import com.example.easy_book.services.UserService;
import com.example.easy_book.utils.RegisterUserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
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
    public String registerUser(@RequestBody RegisterUserRequest request) {
        userService.registerUser(request, "ROLE_USER");
        return "User registered successfully!";
    }
    @PostMapping("/register/hotelier")
    public String registerHotelier(@RequestBody RegisterUserRequest request) {
        userService.registerUser(request, "ROLE_USER,ROLE_HOTELIER");
        return "User registered successfully!";
    }
}
