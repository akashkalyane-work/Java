package com.example.WithDatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@Entity
@NoArgsConstructor
public class UserContact {

    @Id
    @GeneratedValue
    private Long userContactId;

    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String CountryCode;
    @Column(nullable = false)
    private boolean isActive = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;

    public UserContact(Long userContactId, String phoneNumber, String countryCode, User user) {
        this.userContactId = userContactId;
        this.phoneNumber = phoneNumber;
        CountryCode = countryCode;
        this.user = user;
    }

    public UserContact(Long userContactId, String phoneNumber, String countryCode, boolean isActive, User user) {
        this.userContactId = userContactId;
        this.phoneNumber = phoneNumber;
        CountryCode = countryCode;
        this.isActive = isActive;
        this.user = user;
    }
}
