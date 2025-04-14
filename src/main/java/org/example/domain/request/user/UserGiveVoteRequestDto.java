package org.example.domain.request.user;

public record UserGiveVoteRequestDto(
        Integer userId,
        Integer mayorCandidateId
) {
}
