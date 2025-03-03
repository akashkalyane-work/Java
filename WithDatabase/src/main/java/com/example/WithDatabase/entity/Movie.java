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
public class Movie {

    @Id
    @GeneratedValue
    private Long movieId;

    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private String Grade;
    @Column(nullable = false)
    private boolean isAdult;
    @Column(nullable = false)
    private Short ReleaseYear;

    @OneToMany(mappedBy = "Movie")
    private List<Booking> bookings;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId", nullable = false)
    private Genre Genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "directorId", nullable = false)
    private Director Director;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actorId", nullable = false)
    private Actor Actor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CoActorId", nullable = false)
    private Actor CoActor;


}
