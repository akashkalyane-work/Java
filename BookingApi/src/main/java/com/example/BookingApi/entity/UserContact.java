package com.example.BookingApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserContact")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userContactId;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(length = 10, nullable = false)
    private String phoneNumber;

    @Column(length = 3, nullable = false)
    private String countryCode;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    @Column(length = 30, nullable = false)
    private String createdBy;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()::TIMESTAMP")
    private LocalDateTime createOn;

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