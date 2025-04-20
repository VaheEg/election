package org.example.facade.mayorElection.map;

import org.example.domain.entity.MayorElection;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;

public class DefaultMayorElectionMapper implements MayorElectionMapper {
    @Override
    public MayorElectionResponseDto doMap(MayorElection mayorElection) {

        return new MayorElectionResponseDto(
                mayorElection.getName(),
                mayorElection.getLocation(),
                mayorElection.getStart(),
                mayorElection.getEnd()
        );
    }
}
