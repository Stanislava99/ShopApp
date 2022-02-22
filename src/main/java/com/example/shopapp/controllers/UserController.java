package com.example.shopapp.controllers;

import com.example.shopapp.model.User;
import com.example.shopapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    ResponseEntity<User> login(@ModelAttribute User user) {
        return ResponseEntity.ok(userService.authenticatedUser(user.getLogin(), user.getPassword()));
    }

    @PostMapping("/register")
    ResponseEntity<User> register(@ModelAttribute User user) {
        return ResponseEntity.ok( userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail()));
    }



}