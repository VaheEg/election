package org.example.domain.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
@Entity
@Table(name = "POLLING_STATION_USERS")
public class PollingStationUser {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "POLLING_STATION_USER_GENERATOR"
    )
    @SequenceGenerator(name = "POLLING_STATION_USER_GENERATOR")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "polling_station_id", nullable = false)
    private PollingStation pollingStation;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
