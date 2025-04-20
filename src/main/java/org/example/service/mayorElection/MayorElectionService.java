package org.example.service.mayorElection;

import org.example.domain.entity.MayorElection;
import org.example.service.mayorElection.params.CreateMayorElectionParams;

import java.util.Optional;

public interface MayorElectionService {

    MayorElection create(CreateMayorElectionParams params);
    void deleteById(Integer id);
    Optional<MayorElection> getByMayorElectionId(Integer id);
}
