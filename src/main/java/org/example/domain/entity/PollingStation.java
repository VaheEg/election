package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "POLLING_STATIONS")
public class PollingStation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "POLLING_STATION_ID_SEQUENCE"
    )
    @SequenceGenerator(name = "POLLING_STATION_ID_SEQUENCE")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    public PollingStation(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
