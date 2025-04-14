package org.example.service.pollinStation.params;

public record UpdatePollingStationParams(
        Integer id,
        String name,
        String location
) {
}
