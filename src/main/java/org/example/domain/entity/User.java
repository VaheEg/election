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
    private Date yearOfBirth;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "passport_id", nullable = false, unique = true)
    private String passportId;

    @Column(name = "check_give_vote", nullable = false)
    private Boolean checkGiveVote;

    public User(String firstName, String lastName, Date yearOfBirth, String location, String passportId, Boolean checkGiveVote) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.location = location;
        this.passportId = passportId;
        this.checkGiveVote = checkGiveVote;
    }
}

