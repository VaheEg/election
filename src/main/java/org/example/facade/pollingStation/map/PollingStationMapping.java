package org.example.facade.pollingStation.map;

import org.example.domain.entity.PollingStation;
import org.example.domain.response.pollingStation.PollingStationResponseDto;
import java.util.List;

public interface PollingStationMapping {
    PollingStationResponseDto doMap(PollingStation pollingStation);
    List<PollingStationResponseDto> getAllMap(List<PollingStation> pollingStations);
}
