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
public class Genre {

    @Id
    @GeneratedValue
    private Long genreId;
    @Column(nullable = false)
    private String Name;

    @OneToMany(mappedBy = "Genre")
    private List<Movie> movies;

}
