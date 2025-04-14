package org.example.facade.pollingStation;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.pollingStation.PollingStationCreateRequestDto;
import org.example.domain.request.pollingStation.PollingStationUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.pollingStation.PollingStationResponseDto;
import org.example.error.Error;
import org.example.facade.pollingStation.map.PollingStationMapping;
import org.example.facade.pollingStation.validate.PollingStationValidation;
import org.example.service.pollinStation.PollingStationService;
import org.example.service.pollinStation.params.CreatePollingStationParams;
import org.example.service.pollinStation.params.UpdatePollingStationParams;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultPollingStationFacade implements PollingStationFacade{

    private final PollingStationValidation pollingStationValidation;
    private final PollingStationService pollingStationService;
    private final PollingStationMapping pollingStationMapping;

    @Override
    public GenericResponseDto<PollingStationResponseDto> create(PollingStationCreateRequestDto createDto) {

        final var validateCreateOptional = pollingStationValidation.createValidate(createDto);
        if(validateCreateOptional.isPresent()) {
            return new GenericResponseDto<>(validateCreateOptional.get());
        }
        final var pollingStation = pollingStationService.create(
                new CreatePollingStationParams(
                        createDto.name(), createDto.location()));
        final var response = pollingStationMapping.doMap(pollingStation);

        return new GenericResponseDto<>(response);
    }

    @Override
    public GenericResponseDto<PollingStationResponseDto> update(PollingStationUpdateRequestDto updateDto, Integer id) {

        final var validateUpdateOptional = pollingStationValidation.updateValidate(updateDto, id);
        if(validateUpdateOptional.isPresent()) {
            return new GenericResponseDto<>(validateUpdateOptional.get());
        }
        final var pollingStation = pollingStationService.update(
                new UpdatePollingStationParams(
                        id, updateDto.name(), updateDto.location()));

        if(pollingStation.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("Polling station not found");

            return new GenericResponseDto<>(error);
        }

        final var responseDto = pollingStationMapping.doMap(pollingStation.get());

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<PollingStationResponseDto> getById(Integer id) {

        Optional<Error> validateGetById = pollingStationValidation.getByIdValidate(id);
        if(validateGetById.isPresent()) {
            return new GenericResponseDto<>(validateGetById.get());
        }

        final var pollingStation = pollingStationService.getById(id);

        if(pollingStation.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("Polling station not found");
            return new GenericResponseDto<>(error);
        }

        final var responseDto = pollingStationMapping.doMap(pollingStation.get());

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<List<PollingStationResponseDto>> getAll() {

        final var allPollingStations = pollingStationService.getAll();
        final var responseDtos = pollingStationMapping.getAllMap(allPollingStations);

        return new GenericResponseDto<>(responseDtos);
    }

    @Override
    public GenericResponseDto<Void> deleteById(Integer id) {

        return pollingStationValidation.deleteValidate(id);
    }
}
