package org.example.facade.mayorElection.validate;

import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.error.Error;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultMayorElectionValidation implements MayorElectionValidation {

    @Override
    public Optional<Error> createRequestDtoValidate(MayorElectionCreateRequestDto createDto) {

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

        return Optional.empty();
    }

    @Override
    public Optional<Error> deleteRequestDtoValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }
        return Optional.empty();
    }
}
