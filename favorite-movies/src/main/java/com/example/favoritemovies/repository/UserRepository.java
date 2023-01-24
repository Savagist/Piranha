package com.example.favoritemovies.repository;

import com.example.favoritemovies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
}
