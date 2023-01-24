package com.example.favoritemovies.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "favorite_movie")
public class FavoriteMovie {

    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "movie")
    @JsonManagedReference
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonManagedReference
    User user;
}