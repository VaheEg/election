package org.example.service.mayorElection.params;

import java.util.Date;

public record CreateMayorElectionParams(
        String name,
        String location,
        Date start,
        Date end
) {
}
