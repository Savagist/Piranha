package com.example.favoritemovies.repository;

import com.example.favoritemovies.entity.Movie;
import com.example.favoritemovies.entity.User;
import com.example.favoritemovies.entity.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FavMovieRepository extends JpaRepository<FavoriteMovie,Long> {

    List<FavoriteMovie> findAllByUserId(Long userId);
    void deleteById(Long id);

    FavoriteMovie findAllByUserAndMovie(User user, Movie movie);
}
