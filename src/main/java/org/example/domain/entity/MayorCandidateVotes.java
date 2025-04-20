package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "MAYOR_CANDIDATE_VOTES")
public class MayorCandidateVotes {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAYOR_CANDIDATE_VOTES_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "MAYOR_CANDIDATE_VOTES_ID_SEQUENCE")
    private Integer id;

    @Column(name = "mayor_candidate_id", nullable = false, unique = true)
    @ManyToOne
    private MayorCandidate mayorCandidate;

    @Column(name = "votes_count", nullable = false)
    private Integer votesCount;

    public MayorCandidateVotes(MayorCandidate mayorCandidate, Integer votesCount) {
        this.mayorCandidate = mayorCandidate;
        this.votesCount = votesCount;
    }
}
