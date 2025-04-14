package org.example.facade.mayorCandidate;

import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import java.util.List;

public interface MayorCandidateFacade {
    GenericResponseDto<MayorCandidateResponseDto> create(Integer userId);
    GenericResponseDto<MayorCandidateResponseDto> getById(Integer id);
    GenericResponseDto<List<MayorCandidateResponseDto>> getAll();
    GenericResponseDto<Void> deleteById(Integer id);
}
