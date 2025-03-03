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
public class Director {

    public Director(Integer directorId) {
        this.directorId = directorId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer directorId;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 20)
    private String typeOfMovies;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private User createdBy;

    private LocalDateTime createOn = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "changedBy")
    private User changedBy;

    @Column
    private LocalDateTime changedOn;

    @ManyToOne
    @JoinColumn(name = "deletedBy")
    private User deletedBy;

    @Column
    private LocalDateTime deletedOn;
}
