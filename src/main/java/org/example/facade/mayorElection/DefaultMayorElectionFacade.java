package org.example.facade.mayorElection;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;
import org.example.facade.mayorElection.map.MayorElectionMapper;
import org.example.facade.mayorElection.validate.MayorElectionValidation;
import org.example.service.mayorElection.MayorElectionService;
import org.example.service.mayorElection.params.CreateMayorElectionParams;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultMayorElectionFacade implements MayorElectionFacade {

    private final MayorElectionValidation mayorElectionValidation;
    private final MayorElectionService mayorElectionService;
    private final MayorElectionMapper mayorElectionMapper;

    @Override
    public GenericResponseDto<MayorElectionResponseDto> create(MayorElectionCreateRequestDto createDto) {

        final var createValidatedOptional = mayorElectionValidation.createRequestDtoValidate(createDto);

        if(createValidatedOptional.isPresent()) {
            return new GenericResponseDto<>(createValidatedOptional.get());
        }

        final var mayorElection = mayorElectionService.create(new CreateMayorElectionParams(
                createDto.name(),
                createDto.location(),
                createDto.start(),
                createDto.end()
        ));

        final var mayorElectionResponseDto = mayorElectionMapper.doMap(mayorElection);

        return new GenericResponseDto<>(mayorElectionResponseDto);
    }

    @Override
    public GenericResponseDto<Void> deleteById(Integer id) {

        final var deleteByIdValidatedOptional = mayorElectionValidation.deleteRequestDtoValidate(id);

        mayorElectionService.deleteById(id);

        return new GenericResponseDto<>();
    }
}
