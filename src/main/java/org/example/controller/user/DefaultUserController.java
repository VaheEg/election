package org.example.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.example.domain.response.user.UserResponseDto;
import org.example.facade.user.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class DefaultUserController implements UserController {

    private final UserFacade userFacade;

    @Override
    @PostMapping
    public ResponseEntity<GenericResponseDto<UserResponseDto>> create(
            @RequestBody UserCreateRequestDto createDto) {
        log.info("Received create user request, request - {} ", createDto);

        final var userResponseDto = userFacade.create(createDto);

        log.info("Successfully executed create user rest api, response entity - {}", userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDto<UserResponseDto>> update(
            @RequestBody UserUpdateRequestDto updateDto,
            @PathVariable(name = "id") Integer id) {
        log.info("Received update user request, request - {}", updateDto);

        final var userResponseDto = userFacade.update(updateDto, id);

        log.info("Successfully executed update user rest api, response entity - {}", userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<UserResponseDto>> getById(
            @PathVariable(name = "id") Integer id) {
        log.info("Received get by id user request, id - {}", id);

        final var userResponseDto = userFacade.getById(id);

        log.info("Successfully executed get by id user rest api, response entity - {}", userResponseDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDto<Void>> deleteById(
            @PathVariable(name = "id") Integer id) {
        log.info("Received delete user by id request, id - {}", id);

        final var userResponseDto = userFacade.deleteById(id);

        log.info("Successfully executed delete by id user rest api");
        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @PutMapping("/votes/id")
    public ResponseEntity<GenericResponseDto<MayorCandidateVotesResponseDto>> giveVote(UserGiveVoteRequestDto userGiveVoteRequestDto) {
        log.info("Received give vote to the mayor candidate request, request - {}", userGiveVoteRequestDto);

        var mayorCandidateVotesResponseDto = userFacade.giveVote(userGiveVoteRequestDto);

        log.info("Successfully executed give vote to the mayor candidate rest api, response entity - {}", mayorCandidateVotesResponseDto);
        return ResponseEntity.ok(mayorCandidateVotesResponseDto);
    }
}
