package org.example.facade.pollingStation.validate;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.pollingStation.PollingStationCreateRequestDto;
import org.example.domain.request.pollingStation.PollingStationUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;
import org.example.facade.pollingStation.map.PollingStationMapping;
import org.example.service.pollinStation.PollingStationService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPollingStationValidation implements PollingStationValidation {

    private final PollingStationService pollingStationService;
    private final PollingStationMapping pollingStationMapping;

    @Override
    public Optional<Error> createValidate(PollingStationCreateRequestDto params) {

        if(params.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        if(params.name() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Name must not be null");
            return Optional.of(error);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Error> updateValidate(PollingStationUpdateRequestDto params, Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }
        if(params.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        if(params.name() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Error> getByIdValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }


        return Optional.empty();
    }

    @Override
    public GenericResponseDto<Void> deleteValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return new GenericResponseDto<>(error);
        }
        pollingStationService.deleteById(id);

        return new GenericResponseDto<>();
    }
}
