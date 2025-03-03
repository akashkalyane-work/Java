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
public class Genre {

    public Genre(int genreId) {
        this.genreId = genreId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    @Column(nullable = false, length = 40)
    private String genreName;

    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false)
    private User createdBy;

    @Column(name = "createdOn", nullable = false)
    private LocalDateTime createdOn = LocalDateTime.now();

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
