package org.example.domain.request.mayorElection;

import java.util.Date;

public record MayorElectionCreateRequestDto(
        String name,
        String location,
        Date start,
        Date end
) {
}
