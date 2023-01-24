package com.example.feedback.repository;

import com.example.feedback.entity.Feedback;
import com.example.feedback.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Feedback getFeedbackByMovieIdAndUserId(Long movieId,Long userId);

    void deleteById(Long feedbackId);

}
