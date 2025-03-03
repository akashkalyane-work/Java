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
public class Slot {

    @Id
    @GeneratedValue
    private Long slotId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isAvailable;

    @OneToMany(mappedBy = "Slot")
    private List<Booking> bookings;


}
