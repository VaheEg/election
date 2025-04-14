package org.example.controller.mayorCandidate;

import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface MayorCandidateController {
    ResponseEntity<GenericResponseDto<MayorCandidateResponseDto>> create(Integer userId);
    ResponseEntity<GenericResponseDto<MayorCandidateResponseDto>> getById(Integer id);
    ResponseEntity<GenericResponseDto<List<MayorCandidateResponseDto>>> getAll();
    ResponseEntity<GenericResponseDto<Void>> deleteById(Integer id);
}
