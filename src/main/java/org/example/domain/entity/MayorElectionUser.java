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

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAYOR_ELECTION_USERS_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "MAYOR_ELECTION_USERS_ID_SEQUENCE")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mayor_election_id", nullable = false)
    private MayorElection mayorElection;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "check_give_vote", nullable = false)
    private Boolean checkGiveVote;

    public MayorElectionUser(MayorElection mayorElection, User user) {
        this.mayorElection = mayorElection;
        this.user = user;
    }

    public MayorElectionUser(MayorElection mayorElection, User user, Boolean checkGiveVote) {
        this.mayorElection = mayorElection;
        this.user = user;
        this.checkGiveVote = checkGiveVote;
    }
}
