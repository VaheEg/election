package org.example.facade.pollingStation.map;

import org.example.domain.entity.PollingStation;
import org.example.domain.response.pollingStation.PollingStationResponseDto;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultPollingStationMapping implements PollingStationMapping {
    @Override
    public PollingStationResponseDto doMap(PollingStation pollingStation) {

        return new PollingStationResponseDto(pollingStation.getName(), pollingStation.getLocation());
    }

    @Override
    public List<PollingStationResponseDto> getAllMap(List<PollingStation> pollingStations) {

        return pollingStations
                .stream()
                .map(pollingStation -> {return new PollingStationResponseDto(
                pollingStation.getName(),pollingStation.getLocation());})
                .collect(Collectors.toList());
    }
}