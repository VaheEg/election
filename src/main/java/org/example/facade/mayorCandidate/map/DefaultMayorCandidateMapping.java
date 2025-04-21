package org.example.facade.mayorCandidate.map;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorCandidate;
import org.example.domain.entity.MayorCandidateVotes;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DefaultMayorCandidateMapping implements MayorCandidateMapping{

    @Override
    public MayorCandidateResponseDto doMap(MayorCandidate mayorCandidate) {
        log.debug("Mapping mayorCandidate to MayorCandidateResponseDto for the provided mayorCandidate - {}", mayorCandidate);

        var responseDto = new MayorCandidateResponseDto(mayorCandidate.getUser());

        log.debug("Successfully mapped mayorCandidate to MayorCandidateResponseDto, response - {}", responseDto);
        return responseDto;
    }

    @Override
    public List<MayorCandidateResponseDto> getAllMap(List<MayorCandidate> mayorCandidates) {
        log.debug("Mapping list of mayor candidates to list of MayorCandidateResponseDtos for the provided mayorCandidates list - {}", mayorCandidates);

        final List<MayorCandidateResponseDto> responseDtos = mayorCandidates.stream().map(mayorCandidate -> {
            return new MayorCandidateResponseDto(mayorCandidate.getUser());
        }).collect(Collectors.toList());

        log.debug("Successfully mapped list of mayorCandidates to list ofMayorCandidateResponseDtos, response - {}", responseDtos);
        return responseDtos;
    }

    @Override
    public MayorCandidateVotesResponseDto mayorCandidateVotesMapToResponseDto(MayorCandidateVotes mayorCandidateVotes) {
        log.debug("Mapping mayorCandidateVotes to MayorCandidateVotesResponseDto for the provided mayorCandidateVotes - {}", mayorCandidateVotes);

        var responseDto =  new MayorCandidateVotesResponseDto(mayorCandidateVotes.getMayorCandidate(), mayorCandidateVotes.getVotesCount());

        log.debug("Successfully mapped mayorCandidateVotes to MayorCandidateVotesResponseDto, response - {}", responseDto);
        return responseDto;

    }
}
