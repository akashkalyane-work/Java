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
public class TheaterScreen {

    public TheaterScreen(int theaterScreenId){
        this.theaterScreenId = theaterScreenId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterScreenId;

    @ManyToOne
    @JoinColumn(name = "theaterId", nullable = false)
    private Theater theater;

    @Column(nullable = false, length = 20)
    private String screenName;

    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false)
    private User createdBy;

    @Column(nullable = false)
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
