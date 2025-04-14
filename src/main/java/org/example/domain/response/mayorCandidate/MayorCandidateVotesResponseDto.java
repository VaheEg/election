package org.example.domain.response.mayorCandidate;

import org.example.domain.entity.MayorCandidate;

public record MayorCandidateVotesResponseDto(
        MayorCandidate mayorCandidate,
        Integer votesCount
) {
}
