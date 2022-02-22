package com.example.shopapp.services;

import com.example.shopapp.model.User;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String login, String password, String email) {
        if (login == null || password == null) {
            return null;
        } else
        {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }

    public User authenticatedUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
