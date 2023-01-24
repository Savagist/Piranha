package com.example.favoritemovies.repository;
import com.example.favoritemovies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends  JpaRepository<Movie,Long>{
    Movie findMovieById(Long id);
}
