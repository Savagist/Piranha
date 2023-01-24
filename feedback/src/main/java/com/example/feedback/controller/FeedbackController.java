package com.example.feedback.controller;

import com.example.feedback.entity.Feedback;
import com.example.feedback.entity.Movie;
import com.example.feedback.entity.User;
import com.example.feedback.repository.FeedbackRepository;
import com.example.feedback.repository.MovieRepository;
import com.example.feedback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;


    @GetMapping("/feedback/{movieId}/{userId}")
    Feedback getFeedbackById(@PathVariable("movieId") Long movieId, @PathVariable("userId") Long userId) {
        System.out.println(repository.getFeedbackByMovieIdAndUserId(movieId, userId));
        return repository.getFeedbackByMovieIdAndUserId(movieId, userId);
    }

    @DeleteMapping("/feedback/{id}")
    void deleteFeedbackById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/feedback/{movieId}/{userId}")
    Feedback addFeedback(@PathVariable("movieId") Long movieId, @PathVariable("userId") Long userId, @RequestBody Integer newRating, @RequestBody String newComment) {
        Feedback feedback = new Feedback();
        User user = userRepository.findUserById(userId);
        Movie movie = movieRepository.findMovieById(movieId);
        feedback.setUser(user);
        feedback.setMovie(movie);
        if (newRating < 0 || newRating > 10)
           newRating = 0;
        feedback.rating = newRating;
        feedback.comment = newComment;
        return repository.save(feedback);
    }
}
