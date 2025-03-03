package com.example.WithDatabase.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(name = "UQ_users_UserName", columnNames = "UserName"),
    @UniqueConstraint(name = "UQ_users_Email", columnNames = "Email")
})
public class User {
    @Id
    @GeneratedValue
    private long userId;

    @Column(name = "UserName", nullable = false)
    private String username;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;

//    this is for the bidirectional

//    @OneToOne(mappedBy = "user")
//    private UserDetail userDetail;

}
