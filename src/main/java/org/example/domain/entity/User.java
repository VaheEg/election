package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "USER_ID_SEQUENCE"

    )
    @SequenceGenerator(name = "USER_ID_SEQUENCE")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "year_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "social_security_number", nullable = false, unique = true)
    private String socialSecurityNumber;

    @Column(name = "password", nullable = false)
    private String password;

    public User(String firstName, String lastName, Date dateOfBirth, String location, String socialSecurityNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.socialSecurityNumber = socialSecurityNumber;
        this.password = password;
    }
}

