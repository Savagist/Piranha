package com.example.feedback.repository;
import com.example.feedback.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends  JpaRepository<Movie,Long>{
    Movie findMovieById(Long id);
}
