package com.example.application.repository;

import com.example.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); // Eğer email ile giriş yapıyorsan
} 