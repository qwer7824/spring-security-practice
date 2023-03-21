package com.example.springsecuritypractice.user.repository;

import com.example.springsecuritypractice.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
