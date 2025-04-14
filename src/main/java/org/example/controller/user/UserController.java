package org.example.controller.user;

import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.example.domain.response.user.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<GenericResponseDto<UserResponseDto>> create(UserCreateRequestDto createDto);
    ResponseEntity<GenericResponseDto<UserResponseDto>> update(UserUpdateRequestDto updateDto, Integer id);
    ResponseEntity<GenericResponseDto<UserResponseDto>> getById(Integer id);
    ResponseEntity<GenericResponseDto<Void>> deleteById(Integer id);
    ResponseEntity<GenericResponseDto<MayorCandidateVotesResponseDto>> giveVote(UserGiveVoteRequestDto userGiveVoteRequestDto);
}
