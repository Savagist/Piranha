package com.example.feedback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movie")
public class Movie {

    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String about;

    //Bi-direct
    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<Feedback> feedbacks;
}