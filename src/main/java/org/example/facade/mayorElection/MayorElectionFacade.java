package org.example.facade.mayorElection;

import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;

public interface MayorElectionFacade {

    GenericResponseDto<MayorElectionResponseDto> create(MayorElectionCreateRequestDto createDto);
    GenericResponseDto<Void> deleteById(Integer id);
}
