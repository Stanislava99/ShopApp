package com.example.shopapp.services;

import com.example.shopapp.Helper.Role;
import com.example.shopapp.model.User;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
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
            if(userRepository.findByLogin(login).isPresent() || userRepository.findByEmail(email).isPresent())
                return null;
            }
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }


    public User authenticatedUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public User updateUser(Long id,User user) {
        Optional<User> user1 = userRepository.findById(id);
        if(user1.isPresent()) {
            user.setId(id);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        }
        return null;
    }

    public String getUserRole(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> value.getRole().toString()).orElse(null);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initAdmin() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        user.setEmail("admin@shopapp.com");
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
