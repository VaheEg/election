package org.example.service.mayorElection;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.MayorElection;
import org.example.respository.MayorElectionUserRepository;
import org.example.service.mayorElection.params.CreateMayorElectionParams;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultMayorElectionService implements MayorElectionService {

    private final MayorElectionUserRepository mayorElectionUserRepository;

    @Override
    public MayorElection create(CreateMayorElectionParams params) {

        MayorElection mayorElection = new MayorElection(
                params.name(),
                params.location(),
                params.start(),
                params.end()
        );

        return mayorElectionUserRepository.save(mayorElection);
    }

    @Override
    public void deleteById(Integer id) {

        mayorElectionUserRepository.deleteById(id);
    }

    @Override
    public Optional<MayorElection> getByMayorElectionId(Integer id) {

        return mayorElectionUserRepository.findById(id);

    }
}
