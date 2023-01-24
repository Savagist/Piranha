package com.example.favoritemovies.controller;

import com.example.favoritemovies.entity.FavoriteMovie;
import com.example.favoritemovies.entity.User;
import com.example.favoritemovies.repository.FavMovieRepository;
import com.example.favoritemovies.repository.MovieRepository;
import com.example.favoritemovies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class FavMovieController {

    @Autowired
    private FavMovieRepository repository;

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/favFilms/{id}")
    List<FavoriteMovie> getFavorite(@PathVariable Long id) {
        return repository.findAllByUserId(id);
    }


    @PostMapping("/favFilms/{movieId}/{userId}")
    FavoriteMovie addFavorite(@PathVariable Long movieId,@PathVariable Long userId) {
        FavoriteMovie favoriteMovie = new FavoriteMovie();
        favoriteMovie.setMovie(movieRepository.findMovieById(movieId));
        @Req
        favoriteMovie.setUser(userRepository.findUserById(userId));
        if(repository.findAllByUserAndMovie(favoriteMovie.getUser(),favoriteMovie.getMovie())==null){
            return repository.save(favoriteMovie);
        }
        else{
            return repository.findAllByUserAndMovie(favoriteMovie.getUser(),favoriteMovie.getMovie());
        }

    }

    @DeleteMapping("/favFilms/{id}")
    void deleteMovie(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/favFilms/")
    List<FavoriteMovie> getAll(){
        return repository.findAll();
    }


}
