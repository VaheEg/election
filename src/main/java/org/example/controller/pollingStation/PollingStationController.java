package org.example.controller.pollingStation;

import org.example.domain.request.pollingStation.PollingStationCreateRequestDto;
import org.example.domain.request.pollingStation.PollingStationUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.pollingStation.PollingStationResponseDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PollingStationController {
    ResponseEntity<GenericResponseDto<PollingStationResponseDto>> create(PollingStationCreateRequestDto pollingStationCreateRequestDto);
    ResponseEntity<GenericResponseDto<PollingStationResponseDto>> update(PollingStationUpdateRequestDto pollingStationUpdateRequestDto, Integer id);
    ResponseEntity<GenericResponseDto<PollingStationResponseDto>> getById(Integer id);
    ResponseEntity<GenericResponseDto<List<PollingStationResponseDto>>> getAll();
    ResponseEntity<GenericResponseDto<Void>>  deleteById(Integer id);
}
