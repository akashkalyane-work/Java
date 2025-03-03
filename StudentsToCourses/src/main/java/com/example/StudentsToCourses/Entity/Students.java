package com.example.StudentsToCourses.Entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jpa_students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Email(message = "Enter valid email !!")
    @NotEmpty
    private String email;

    @NotEmpty @Size(min = 4, message = "Firstname must be minimum of 4 Characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty @Size(min = 4, message = "Lastname must be minimum of 4 Characters")
    @Column(name = "last_name")
    private String lastName;

    private Integer age;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$" ,message = "a digit,lowercase,uppercase,special character,no whitespace must occur once and at least 8 characters")
    private String password;


    @OneToMany(mappedBy = "students",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Courses> courses = new ArrayList<>();
}
