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
public class Actor {

    public Actor(Integer actorId) {
        this.actorId = actorId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Boolean hasAward;

    @Column(nullable = false)
    private Integer noOfMoviesWorkedOn;

    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false)
    private User createdBy;

    @Column(nullable = false)
    private LocalDateTime createOn = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "changedBy")
    private User changedBy;

    @Column()
    private LocalDateTime changedOn;

    @ManyToOne
    @JoinColumn(name = "deletedBy")
    private User deletedBy;

    @Column
    private LocalDateTime deletedOn;
}
