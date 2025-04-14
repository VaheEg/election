package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MAYOR_ELECTION_POLLING_STATIONS")
public class MayorElectionPollingStation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MAYOR_ELECTION_POLLING_STATION_ID_SEQUENCE"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mayor_election_id", nullable = false)
    private MayorElection mayorElection;

    @OneToOne
    @JoinColumn(name = "polling_station_id", nullable = false, unique = true)
    private PollingStation pollingStation;
}
