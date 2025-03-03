package com.example.BookingApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    public Movie(int movieId) {
        this.movieId = movieId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(nullable = false, length = 50)
    private String movieName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genreId", nullable = false)
    private Genre genre;

    @Column(nullable = false, length = 5)
    private String grade;

    @Column(nullable = false)
    private Boolean isAdult;

    @Column(nullable = false, length = 10)
    private String releaseYear;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "directorId", nullable = false)
    private Director director;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mainActorMale", nullable = false)
    private Actor mainActorMale;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mainActorFemale", nullable = false)
    private Actor mainActorFemale;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "createdBy", nullable = false)
    private User createdBy;

    @Column(nullable = false)
    private LocalDateTime createOn = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "changedBy")
    private User changedBy;

    @Column
    private LocalDateTime changedOn;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "deletedBy")
    private User deletedBy;

    @Column
    private LocalDateTime deletedOn;
}
