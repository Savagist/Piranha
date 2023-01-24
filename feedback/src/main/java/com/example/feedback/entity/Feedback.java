package com.example.feedback.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "feedback")
public class Feedback {

    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public String comment;

    public Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    Movie movie;
}
