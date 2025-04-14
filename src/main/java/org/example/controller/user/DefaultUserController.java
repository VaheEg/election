package org.example.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.example.domain.response.user.UserResponseDto;
import org.example.facade.user.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class DefaultUserController implements UserController {

    private final UserFacade userFacade;

    @Override
    @PostMapping
    public ResponseEntity<GenericResponseDto<UserResponseDto>> create(
            @RequestBody UserCreateRequestDto createDto) {

        final var userResponseDto = userFacade.create(createDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GenericResponseDto<UserResponseDto>> update(
            @RequestBody UserUpdateRequestDto updateDto,
            @PathVariable(name = "id") Integer id) {

        final var userResponseDto = userFacade.update(updateDto, id);

        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<UserResponseDto>> getById(
            @PathVariable(name = "id") Integer id) {

        final var userResponseDto = userFacade.getById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDto<Void>> deleteById(
            @PathVariable(name = "id") Integer id) {

        final var userResponseDto = userFacade.deleteById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @Override
    @PutMapping("/votes/id")
    public ResponseEntity<GenericResponseDto<MayorCandidateVotesResponseDto>> giveVote(UserGiveVoteRequestDto userGiveVoteRequestDto) {

        var mayorCandidateVotesResponseDto = userFacade.giveVote(userGiveVoteRequestDto);

        return ResponseEntity.ok(mayorCandidateVotesResponseDto);
    }
}
