package org.example.facade.user;

import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.example.domain.response.user.UserResponseDto;

public interface UserFacade {
    GenericResponseDto<UserResponseDto> create(UserCreateRequestDto createDto);
    GenericResponseDto<UserResponseDto> update(UserUpdateRequestDto updateDto, Integer id);
    GenericResponseDto<UserResponseDto> getById(Integer id);
    GenericResponseDto<Void> deleteById(Integer id);
    GenericResponseDto<MayorCandidateVotesResponseDto> giveVote(UserGiveVoteRequestDto userGiveVoteRequestDto);
}
