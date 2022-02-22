package com.example.shopapp.repos;

import com.example.shopapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);
}
