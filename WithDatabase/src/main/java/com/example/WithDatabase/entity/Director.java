package com.example.WithDatabase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Director {

    @Id
    @GeneratedValue
    private Long directorId;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private Short Age;
    @Column(nullable = false)
    private String TypeOfMovies;

    @OneToMany(mappedBy = "Director")
    private List<Movie> movies;

}
