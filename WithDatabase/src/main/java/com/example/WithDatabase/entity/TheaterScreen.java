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
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "theaterId"})
})
public class TheaterScreen {

    @Id
    @GeneratedValue
    private Long theaterScreenId;

    @Column(name = "name", nullable = false)
    private String Name;

    @OneToMany(mappedBy = "TheaterScreen")
    private List<Booking> bookings;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theaterId", nullable = false)
    private Theater Theater;

}
