package org.example.service.mayorElection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorElection;
import org.example.respository.MayorElectionRepository;
import org.example.service.mayorElection.params.CreateMayorElectionParams;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultMayorElectionService implements MayorElectionService {

    private final MayorElectionRepository mayorElectionRepository;

    @Override
    public MayorElection create(CreateMayorElectionParams params) {
        log.info("Creating mayor election for the provided params - {}", params);

        MayorElection mayorElection = new MayorElection(
                params.name(),
                params.location(),
                params.start(),
                params.end()
        );

        log.info("Successfully created mayor election - {}", mayorElection);
        return mayorElectionRepository.save(mayorElection);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting mayor election by the provided id - {}", id);

        mayorElectionRepository.deleteById(id);

        log.info("Successfully deleted mayor election");
    }

    @Override
    public Optional<MayorElection> getByMayorElectionId(Integer id) {
        log.info("Getting mayor election by the provided id - {}", id);

        final var mayorElectionOptional = mayorElectionRepository.findById(id);

        log.info("Successfully found mayor election, mayor election optional - {}", mayorElectionOptional);
        return mayorElectionOptional;

    }
}
