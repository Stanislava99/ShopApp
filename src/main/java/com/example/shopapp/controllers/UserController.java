package com.example.shopapp.controllers;

import com.example.shopapp.Helper.Role;
import com.example.shopapp.model.User;
import com.example.shopapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/login")
    Long login(@ModelAttribute User user) {
         ResponseEntity.ok(userService.authenticatedUser(user.getLogin(), user.getPassword()));
         return user.getId();
    }

    @PostMapping("/register")
    ResponseEntity<User> register(@ModelAttribute User user) {
        return ResponseEntity.ok( userService.registerUser(user.getLogin(),
                user.getPassword(), user.getEmail(), Role.USER));
    }

    @GetMapping("/users")
    ResponseEntity<Iterable<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user/{id}")
    ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<User> unregisterUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @ModelAttribute User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @GetMapping("/user/{id}/role")
    ResponseEntity<String> getUserRole(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserRole(id));
    }



}