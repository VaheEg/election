package org.example.facade.mayorElection.validate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.error.Error;
import org.example.service.mayorElection.MayorElectionService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultMayorElectionValidation implements MayorElectionValidation {

    private final MayorElectionService mayorElectionService;

    @Override
    public Optional<Error> createRequestDtoValidate(MayorElectionCreateRequestDto createDto) {
        log.debug("Validating createMayorElection requestDto for the provided createDto - {}", createDto);

        if(createDto == null) {
            Error error = Error.REQUEST_DTO_IS_NULL;
            return Optional.of(error);
        }

        if(createDto.name() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Mayor election's name must not be null");
            return Optional.of(error);
        }

        if(createDto.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Mayor election's location must not be null");
            return Optional.of(error);
        }

        if(createDto.start() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Mayor election's start date must not be null");
            return Optional.of(error);
        }

        if(createDto.end() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Mayor election's end date must not be null");
            return Optional.of(error);
        }

        log.debug("Successfully validated createMayorElection requestDto");
        return Optional.empty();
    }

    @Override
    public Optional<Error> deleteRequestDtoValidate(Integer id) {
        log.debug("Validating deleteMayorElection request by provided id - {}", id);

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        log.debug("Successfully validated deleteMayorElection request");
        mayorElectionService.deleteById(id);

        return Optional.empty();
    }
}
