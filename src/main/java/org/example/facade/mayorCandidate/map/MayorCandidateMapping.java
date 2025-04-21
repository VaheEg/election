package org.example.facade.mayorCandidate.map;

import org.example.domain.entity.MayorCandidate;
import org.example.domain.entity.MayorCandidateVotes;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import java.util.List;

public interface MayorCandidateMapping {
    MayorCandidateResponseDto doMap(MayorCandidate mayorCandidate);
    List<MayorCandidateResponseDto> getAllMap(List<MayorCandidate> mayorCandidates);
    MayorCandidateVotesResponseDto mayorCandidateVotesMapToResponseDto(MayorCandidateVotes mayorCandidateVotes);
}
