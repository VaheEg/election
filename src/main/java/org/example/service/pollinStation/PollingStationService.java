package org.example.service.pollinStation;

import org.example.domain.entity.PollingStation;
import org.example.service.pollinStation.params.CreatePollingStationParams;
import org.example.service.pollinStation.params.UpdatePollingStationParams;
import java.util.List;
import java.util.Optional;

public interface PollingStationService {
    PollingStation create(CreatePollingStationParams params);
    Optional<PollingStation> update(UpdatePollingStationParams params);
    Optional<PollingStation> getById(Integer id);
    List<PollingStation> getAll();
    void deleteById(Integer id);
}
