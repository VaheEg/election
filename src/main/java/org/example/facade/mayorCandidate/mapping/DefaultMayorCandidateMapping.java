package org.example.facade.mayorCandidate.mapping;

import org.example.domain.entity.MayorCandidate;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultMayorCandidateMapping implements MayorCandidateMapping{

    @Override
    public MayorCandidateResponseDto doMap(MayorCandidate mayorCandidate) {
        return new MayorCandidateResponseDto(mayorCandidate.getUser());
    }

    @Override
    public List<MayorCandidateResponseDto> getAllMap(List<MayorCandidate> mayorCandidates) {
        return mayorCandidates.stream().map(mayorCandidate -> {
            return new MayorCandidateResponseDto(mayorCandidate.getUser());
        }).collect(Collectors.toList());
    }
}
