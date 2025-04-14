package org.example.service.pollinStation;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.PollingStation;
import org.example.respository.PollingStationRepository;
import org.example.service.pollinStation.params.CreatePollingStationParams;
import org.example.service.pollinStation.params.UpdatePollingStationParams;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultPollingService implements PollingStationService {
    private final PollingStationRepository pollingStationRepository;
    @Override
    public PollingStation create(CreatePollingStationParams params) {

        final var pollingStation = new PollingStation(params.name(), params.location());

        return pollingStationRepository.save(pollingStation);
    }

    @Override
    public Optional<PollingStation> update(UpdatePollingStationParams params) {

        final var pollingStationOptional = pollingStationRepository.findById(params.id());
        if(pollingStationOptional.isEmpty()) {
            return Optional.empty();
        }
        final var pollingStation = pollingStationOptional.get();

        pollingStation.setId(params.id());
        pollingStation.setName(params.name());
        pollingStation.setLocation(params.location());

        var savedPollingStation = pollingStationRepository.save(pollingStation);

        return Optional.of(savedPollingStation);
    }

    @Override
    public Optional<PollingStation> getById(Integer id) {

        return pollingStationRepository.findById(id);
    }

    @Override
    public List<PollingStation> getAll() {

        return pollingStationRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        pollingStationRepository.deleteById(id);

    }
}