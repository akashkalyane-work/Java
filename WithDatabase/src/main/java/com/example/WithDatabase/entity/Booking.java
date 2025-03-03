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
public class Booking {

    @Id
    @GeneratedValue
    private Long bookingId;

    @Column(nullable = false)
    private Short Price;

    @Column(nullable = false)
    private Short NoOfSlots;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movieId")
    private Movie Movie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theaterScreenId")
    private TheaterScreen TheaterScreen;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "slotId")
    private Slot Slot;


}
