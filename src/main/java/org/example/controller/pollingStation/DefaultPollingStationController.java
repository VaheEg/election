package org.example.controller.pollingStation;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.pollingStation.PollingStationCreateRequestDto;
import org.example.domain.request.pollingStation.PollingStationUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.pollingStation.PollingStationResponseDto;
import org.example.facade.pollingStation.PollingStationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/polling-stations")
public class DefaultPollingStationController implements PollingStationController {
    private final PollingStationFacade pollingStationFacade;
    @Override
    @PostMapping
    public ResponseEntity<GenericResponseDto<PollingStationResponseDto>> create(
            @RequestBody PollingStationCreateRequestDto createDto) {

        final var pollingStationResponseDto = pollingStationFacade.create(createDto);

        return ResponseEntity.ok(pollingStationResponseDto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDto<PollingStationResponseDto>> update(
            @RequestBody PollingStationUpdateRequestDto updateDto,
            @PathVariable(name = "id") Integer id) {

        final var pollingStationResponseDto = pollingStationFacade.update(updateDto, id);

        return ResponseEntity.ok(pollingStationResponseDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<PollingStationResponseDto>> getById(Integer id) {

        final var pollingStationResponseDto = pollingStationFacade.getById(id);

        return ResponseEntity.ok(pollingStationResponseDto);
    }

    @Override
    @GetMapping
    public ResponseEntity<GenericResponseDto<List<PollingStationResponseDto>>> getAll() {

        final var pollingStationResponseDto = pollingStationFacade.getAll();

        return ResponseEntity.ok(pollingStationResponseDto);
    }

    @Override
    @DeleteMapping("/id")
    public ResponseEntity<GenericResponseDto<Void>> deleteById(
            @PathVariable(name = "id") Integer id) {

        GenericResponseDto<Void> voidGenericResponseDto = pollingStationFacade.deleteById(id);

        return ResponseEntity.ok(voidGenericResponseDto);
    }
}
