package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MAYOR_CANDIDATES")
public class MayorCandidate {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAYOR_CANDIDATE_ID_SEQUENCE"

    )
    @SequenceGenerator(name = "MAYOR_CANDIDATE_ID_SEQUENCE")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public MayorCandidate(User user) {
        this.user = user;
    }
}
