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
public class Actor {

    @Id
    @GeneratedValue
    private Long actorId;

    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private Short Age;
    @Column(nullable = false)
    private boolean HasAward;
    @Column(nullable = false)
    private Short NoOfMoviesWorkedOn;


    @OneToMany(mappedBy = "Actor")
    private List<Movie> movies;


}
