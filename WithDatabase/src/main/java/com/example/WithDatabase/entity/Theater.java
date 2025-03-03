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
public class Theater {

    @Id
    @GeneratedValue
    private Long theaterId;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private boolean isMultiScreen;

    @OneToMany(mappedBy = "theaterScreenId")
    private List<TheaterScreen> theaterScreens;

}
