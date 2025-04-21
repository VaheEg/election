package org.example.facade.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.example.domain.response.user.UserResponseDto;
import org.example.error.Error;
import org.example.facade.mayorCandidate.map.MayorCandidateMapping;
import org.example.facade.user.map.UserMapping;
import org.example.facade.user.validate.UserValidation;
import org.example.service.mayorCandidateVotes.MayorCandidateVotesService;
import org.example.service.mayorElectionUser.MayorElectionUserService;
import org.example.service.user.UserService;
import org.example.service.user.params.CreateUserParams;
import org.example.service.user.params.UpdateUserParams;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {

    private final UserValidation userValidation;
    private final UserService userService;
    private final UserMapping userMapping;
    private final MayorCandidateVotesService mayorCandidateVotesService;
    private final MayorCandidateMapping mayorCandidateMapping;
    private final MayorElectionUserService mayorElectionUserService;


    @Override
    public GenericResponseDto<UserResponseDto> create(UserCreateRequestDto createDto) {

        if(createDto == null) {
            Error error = Error.REQUEST_DTO_IS_NULL;
            return new GenericResponseDto<>(error);
        }

        final var createValidatedOptional = userValidation.creteRequestDtoValidate(createDto);
        if(createValidatedOptional.isPresent()) {
            return new GenericResponseDto<>(createValidatedOptional.get());
        }

        final var user = userService.create(new CreateUserParams(
                createDto.firstName(),
                createDto.lastName(),
                createDto.yearOfBirth(),
                createDto.location(),
                createDto.socialSecurityNumber(),
                createDto.password()
        ));

        final var responseDto = userMapping.map(user);

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<UserResponseDto> update(UserUpdateRequestDto updateDto, Integer id) {

        if(updateDto == null) {
            Error error = Error.REQUEST_DTO_IS_NULL;
            return new GenericResponseDto<>(error);
        }

        final var updateValidatedOptional = userValidation.updateRequestDtoValidate(updateDto, id);
        if(updateValidatedOptional.isPresent()) {
            return new GenericResponseDto<>(updateValidatedOptional.get());
        }

        var userOptional = userService.update(new UpdateUserParams(
                id,
                updateDto.firstName(),
                updateDto.lastName(),
                updateDto.location(),
                updateDto.socialSecurityNumber(),
                updateDto.password()
        ));

        if(userOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("User not found");

            return new GenericResponseDto<>(error);
        }


        final var responseDto = userMapping.map(userOptional.get());

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<UserResponseDto> getById(Integer id) {

        var getByIdValidatedOptional = userValidation.getByIdValidate(id);
        if(getByIdValidatedOptional.isPresent()) {
            return new GenericResponseDto<>(getByIdValidatedOptional.get());
        }

        var userOptional = userService.getById(id);
        if(userOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("User not found");
            return new GenericResponseDto<>(error);
        }

        final var responseDto = userMapping.map(userOptional.get());

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<Void> deleteById(Integer id) {

        return userValidation.deleteByIdValidate(id);
    }

    @Override
    public GenericResponseDto<MayorCandidateVotesResponseDto> giveVote(UserGiveVoteRequestDto userGiveVoteRequestDto) {

        if(userGiveVoteRequestDto == null) {
            Error error = Error.REQUEST_DTO_IS_NULL;
            return new GenericResponseDto<>(error);
        }

        var giveVoteValidatedOptional = userValidation.giveVoteValidate(userGiveVoteRequestDto);
        if(giveVoteValidatedOptional.isPresent()) {
            return new GenericResponseDto<>(giveVoteValidatedOptional.get());
        }

        final var mayorCandidateVotesOptional = mayorCandidateVotesService.updateVotesCount(userGiveVoteRequestDto.mayorCandidateId());
        if(mayorCandidateVotesOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("Mayor candidate not found");
            return new GenericResponseDto<>(error);
        }

        mayorElectionUserService.updateCheckUserGiveVote(userGiveVoteRequestDto.userId(), userGiveVoteRequestDto.mayorElectionId());

        final var mayorCandidateVotesResponseDto = mayorCandidateMapping.mayorCandidateVotesMapToResponseDto(mayorCandidateVotesOptional.get());

        return new GenericResponseDto<>(mayorCandidateVotesResponseDto);
    }
}

