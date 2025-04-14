package org.example.facade.mayorCandidate.mapping;

import org.example.domain.entity.MayorCandidate;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import java.util.List;

public interface MayorCandidateMapping {
    MayorCandidateResponseDto doMap(MayorCandidate mayorCandidate);
    List<MayorCandidateResponseDto> getAllMap(List<MayorCandidate> mayorCandidates);
}
