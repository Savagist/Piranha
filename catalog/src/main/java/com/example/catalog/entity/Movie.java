package com.example.catalog.entity;

import jakarta.persistence.*;

@Entity(name = "movie")
public class Movie {

    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String about;

    public Movie(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public Movie() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return this.about;
    }


    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
