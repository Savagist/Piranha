package com.example.feedback.repository;
import com.example.feedback.entity.Feedback;
import com.example.feedback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
}
