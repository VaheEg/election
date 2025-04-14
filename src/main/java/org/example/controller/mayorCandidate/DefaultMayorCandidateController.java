package org.example.controller.mayorCandidate;

import lombok.RequiredArgsConstructor;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateResponseDto;
import org.example.facade.mayorCandidate.MayorCandidateFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/mayor-candidates")
public class DefaultMayorCandidateController implements MayorCandidateController {

    private final MayorCandidateFacade mayorCandidateFacade;

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<GenericResponseDto<MayorCandidateResponseDto>> create(@PathVariable(name = "id") Integer userId) {

        var mayorCandidateResponseDto = mayorCandidateFacade.create(userId);

        return ResponseEntity.ok(mayorCandidateResponseDto);
    }

    @Override
    @GetMapping("/id")
    public ResponseEntity<GenericResponseDto<MayorCandidateResponseDto>> getById(@PathVariable(name = "id") Integer id) {

        var mayorCandidateResponseDto = mayorCandidateFacade.getById(id);

        return ResponseEntity.ok(mayorCandidateResponseDto);
    }

    @Override
    @GetMapping
    public ResponseEntity<GenericResponseDto<List<MayorCandidateResponseDto>>> getAll() {

        var mayorCandidatesResponseDto = mayorCandidateFacade.getAll();

        return ResponseEntity.ok(mayorCandidatesResponseDto);
    }

    @Override
    @DeleteMapping("/id")
    public ResponseEntity<GenericResponseDto<Void>> deleteById(@PathVariable(name = "id") Integer id) {

        var mayorCandidateResponseDto = mayorCandidateFacade.deleteById(id);

        return ResponseEntity.ok(mayorCandidateResponseDto);
    }
}
