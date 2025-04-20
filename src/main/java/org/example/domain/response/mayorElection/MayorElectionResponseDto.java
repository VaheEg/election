package org.example.domain.response.mayorElection;

import java.util.Date;

public record MayorElectionResponseDto(
        String name,
        String location,
        Date start,
        Date end
) {
}
