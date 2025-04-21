package org.example.controller.mayorCandidate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.example.facade.mayorCandidate.MayorCandidateFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/mayor-candidates")
public class DefaultMayorCandidateController implements MayorCandidateController {

    private final MayorCandidateFacade mayorCandidateFacade;

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<GenericResponseDto<MayorCandidateResponseDto>> create(@PathVariable(name = "id") Integer userId) {
        log.info("Received create mayor candidate request, id - {}", userId);

        var mayorCandidateResponseDto = mayorCandidateFacade.create(userId);

        log.info("Successfully executed create mayor candidate rest api, response entity - {}", mayorCandidateResponseDto);
        return ResponseEntity.ok(mayorCandidateResponseDto);
    }

    @Override
    @GetMapping("/id")
    public ResponseEntity<GenericResponseDto<MayorCandidateResponseDto>> getById(@PathVariable(name = "id") Integer id) {
        log.info("Received get mayor candidate by id request, id - {}", id);

        var mayorCandidateResponseDto = mayorCandidateFacade.getById(id);

        log.info("Successfully executed get by id mayor candidate rest api, response entity - {}", mayorCandidateResponseDto);
        return ResponseEntity.ok(mayorCandidateResponseDto);
    }

    @Override
    @GetMapping
    public ResponseEntity<GenericResponseDto<List<MayorCandidateResponseDto>>> getAll() {
        log.info("Received get all mayor candidates request");

        var mayorCandidatesResponseDto = mayorCandidateFacade.getAll();

        log.info("Successfully executed get all mayor candidates rest api, response entity - {}", mayorCandidatesResponseDto);
        return ResponseEntity.ok(mayorCandidatesResponseDto);
    }

    @Override
    @DeleteMapping("/id")
    public ResponseEntity<GenericResponseDto<Void>> deleteById(@PathVariable(name = "id") Integer id) {
        log.info("Received delete mayor candidate by id request, id - {}", id);

        var mayorCandidateResponseDto = mayorCandidateFacade.deleteById(id);

        log.info("Successfully executed delete by id mayor candidate rest api");
        return ResponseEntity.ok(mayorCandidateResponseDto);
    }
}
