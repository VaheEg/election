package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "MAYOR_ELECTIONS")
public class MayorElection {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAYOR_ELECTION_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "MAYOR_ELECTION_ID_SEQUENCE")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "start", nullable = false)
    private final Date start;

    @Column(name = "end", nullable = false)
    private final Date end;

    public MayorElection(String name, String location, Date start, Date end) {
        this.name = name;
        this.location = location;
        this.start = start;
        this.end = end;
    }
}
