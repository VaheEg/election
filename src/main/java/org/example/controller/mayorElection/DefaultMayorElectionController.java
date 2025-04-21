package org.example.controller.mayorElection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;
import org.example.facade.mayorElection.MayorElectionFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mayor-elections")
@RequiredArgsConstructor
public class DefaultMayorElectionController implements MayorElectionController {

    private final MayorElectionFacade mayorElectionFacade;

    @Override
    @PostMapping
    public ResponseEntity<GenericResponseDto<MayorElectionResponseDto>> create(MayorElectionCreateRequestDto createDto) {
        log.info("Received create mayor election request, request - {}", createDto);

        final var createResponseDto = mayorElectionFacade.create(createDto);

        log.info("Successfully executed create mayor election rest api, response entity - {}", createResponseDto);
        return ResponseEntity.ok(createResponseDto);
    }

    @Override
    @DeleteMapping("/id")
    public ResponseEntity<GenericResponseDto<Void>> deleteById(
            @PathVariable("id") Integer id) {
        log.info("Received delete by id mayor election request, id - {}", id);

        final var deleteResponseDto = mayorElectionFacade.deleteById(id);

        log.info("Successfully executed delete by id mayor election rest api");
        return ResponseEntity.ok(deleteResponseDto);
    }
}

