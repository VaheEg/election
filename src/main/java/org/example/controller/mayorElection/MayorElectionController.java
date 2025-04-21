package org.example.controller.mayorElection;

import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;
import org.springframework.http.ResponseEntity;

public interface MayorElectionController {
    ResponseEntity<GenericResponseDto<MayorElectionResponseDto>> create(MayorElectionCreateRequestDto createDto);
    ResponseEntity<GenericResponseDto<Void>> deleteById(Integer id);
}
