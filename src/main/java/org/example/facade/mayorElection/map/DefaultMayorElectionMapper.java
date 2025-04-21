package org.example.facade.mayorElection.map;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorElection;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultMayorElectionMapper implements MayorElectionMapper {
    @Override
    public MayorElectionResponseDto doMap(MayorElection mayorElection) {
        log.debug("Mapping mayorElection to MayorElectionResponseDto for the provided mayorElection - {}", mayorElection);

        var responseDto = new MayorElectionResponseDto(
                mayorElection.getName(),
                mayorElection.getLocation(),
                mayorElection.getStart(),
                mayorElection.getEnd()
        );

        log.debug("Successfully mapped mayorElection to MAyorElectionResponseDto, response - {}", responseDto);
        return responseDto;
    }
}
