package org.example.controller.mayorElection;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.mayorElection.MayorElectionCreateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorElection.MayorElectionResponseDto;
import org.example.facade.mayorElection.MayorElectionFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mayor-elections")
@RequiredArgsConstructor
public class DefaultMayorElectionController implements MayorElectionController {

    private final MayorElectionFacade mayorElectionFacade;

    @Override
    @PostMapping
    public ResponseEntity<GenericResponseDto<MayorElectionResponseDto>> create(MayorElectionCreateRequestDto createDto) {

        final var createResponseDto = mayorElectionFacade.create(createDto);

        return ResponseEntity.ok(createResponseDto);
    }

    @Override
    @DeleteMapping("/id")
    public ResponseEntity<GenericResponseDto<Void>> delete(
            @PathVariable("id") Integer id) {

        final var deleteResponseDto = mayorElectionFacade.deleteById(id);

        return ResponseEntity.ok(deleteResponseDto);
    }
}

