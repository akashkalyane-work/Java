package com.example.WithDatabase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Data
@NoArgsConstructor
@Entity
public class UserDetail {

    @Id
    @GeneratedValue
    private Long userDetailId;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "MiddleName", nullable = false)
    private String middleName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    private String fullNameFL;
    private String fullNameLF;
    private String fullNameFML;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    private User user;

    public UserDetail(Long userDetailId, String firstName, String middleName, String lastName, User user) {
        this.userDetailId = userDetailId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullNameFL = firstName + " " + lastName;
        this.fullNameLF = lastName + " " + firstName;
        this.fullNameFML = firstName + " " + middleName + " " +lastName;
        this.user = user;
    }
}
