package com.example.BookingApi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

// Booking Entity
@Entity
@Table(name = "Booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "MovieId", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "TheaterScreenId", nullable = false)
    private TheaterScreen theaterScreen;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "SlotId", nullable = false)
    private Slot slot;

    @Column(nullable = false)
    private Integer numberOfSlot;

    @ManyToOne
    @JoinColumn(name = "CreatedBy", nullable = false)
    private User createdBy;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()::TIMESTAMP")
    private LocalDateTime createOn;

    @ManyToOne
    @JoinColumn(name = "ChangedBy")
    private User changedBy;

    @Column
    private LocalDateTime changedOn;

    @ManyToOne
    @JoinColumn(name = "DeletedBy")
    private User deletedBy;

    @Column
    private LocalDateTime deletedOn;
}

