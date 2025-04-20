package org.example.facade.mayorElection.validate;

import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.error.Error;
import java.util.Optional;

public interface MayorElectionValidation {
    Optional<Error> createRequestDtoValidate(MayorElectionCreateRequestDto createDto);
    Optional<Error> deleteRequestDtoValidate(Integer id);
}
