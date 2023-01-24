package com.example.catalog.controller;

import com.example.catalog.entity.Movie;
import com.example.catalog.exception.MovieNotFoundException;
import com.example.catalog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CatalogController {
    @Autowired
    private MovieRepository repository;

    @GetMapping("/film/mainPage/")
    List<Movie> getMainPage() {
        return repository.findAll();
    }

    @PostMapping("/film/mainPage/")
    Movie addFilms(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
    }

    @GetMapping("/film/mainPage/{id}")
    Movie getFilmDescById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PutMapping("/film/mainPage/{id}")
    Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {
        return repository.findById(id)
                .map(movie -> {
                    movie.setName(newMovie.getName());
                    movie.setAbout(newMovie.getAbout());
                    return repository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    @DeleteMapping("/film/mainPage/{id}")
    void deleteFilmById(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
