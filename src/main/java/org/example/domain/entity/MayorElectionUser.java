package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(
        name = "MAYOR_ELECTION_USERS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"mayor_election_id", "user_id"})
)
public class MayorElectionUser {

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAYOR_ELECTION_USERS_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "MAYOR_ELECTION_USERS_ID_SEQUENCE")
    private Integer id;

    @Column(name = "mayor_election_id", nullable = false)
    @ManyToOne
    private MayorElection mayorElection;

    @Column(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @Column(name = "check_give_vote", nullable = false)
    private Boolean checkGiveVote;

    public MayorElectionUser(MayorElection mayorElection, User user) {
        this.mayorElection = mayorElection;
        this.user = user;
    }
}
