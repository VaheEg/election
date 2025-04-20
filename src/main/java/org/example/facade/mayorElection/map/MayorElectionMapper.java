package org.example.facade.mayorElection.map;

import org.example.domain.entity.MayorElection;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;

public interface MayorElectionMapper {
    MayorElectionResponseDto doMap(MayorElection mayorElection);
}
