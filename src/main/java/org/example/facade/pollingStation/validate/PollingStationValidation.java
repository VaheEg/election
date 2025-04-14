package org.example.facade.pollingStation.validate;

import org.example.domain.request.pollingStation.PollingStationCreateRequestDto;
import org.example.domain.request.pollingStation.PollingStationUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;

import java.util.Optional;

public interface PollingStationValidation {
    Optional<Error> createValidate(PollingStationCreateRequestDto params);
    Optional<Error> updateValidate(PollingStationUpdateRequestDto params, Integer id);
    Optional<Error> getByIdValidate(Integer id);
    GenericResponseDto<Void> deleteValidate(Integer id);

}
