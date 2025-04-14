package org.example.facade.pollingStation;

import org.example.domain.request.pollingStation.PollingStationCreateRequestDto;
import org.example.domain.request.pollingStation.PollingStationUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.pollingStation.PollingStationResponseDto;
import java.util.List;

public interface PollingStationFacade {
    GenericResponseDto<PollingStationResponseDto> create(PollingStationCreateRequestDto createDto);
    GenericResponseDto<PollingStationResponseDto> update(PollingStationUpdateRequestDto updateDto, Integer id);
    GenericResponseDto<PollingStationResponseDto> getById(Integer id);
    GenericResponseDto<List<PollingStationResponseDto>> getAll();
    GenericResponseDto<Void> deleteById(Integer id);
}
