package org.example.facade.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.domain.response.mayorCandidate.MayorCandidateVotesResponseDto;
import org.example.domain.response.user.UserResponseDto;
import org.example.error.Error;
import org.example.facade.user.map.UserMapping;
import org.example.facade.user.validate.UserValidation;
import org.example.service.user.UserService;
import org.example.service.user.params.CreateUserParams;
import org.example.service.user.params.UpdateUserParams;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {

    private final UserValidation userValidation;
    private final UserService userService;
    private final UserMapping userMapping;

    @Override
    public GenericResponseDto<UserResponseDto> create(UserCreateRequestDto createDto) {

        final var validateCreateOptional = userValidation.creteRequestDtoValidate(createDto);
        if(validateCreateOptional.isPresent()) {
            return new GenericResponseDto<>(validateCreateOptional.get());
        }

        final var user = userService.create(new CreateUserParams(
                createDto.firstName(),
                createDto.lastName(),
                createDto.yearOfBirth(),
                createDto.location(),
                createDto.passportId()

        ));

        final var responseDto = userMapping.map(user);

        return new GenericResponseDto<>(responseDto);
    }

    @Override
    public GenericResponseDto<UserResponseDto> update(UserUpdateRequestDto updateDto, Integer id) {

        final var validateUpdateOptional = userValidation.updateRequestDtoValidate(updateDto, id);
        if(validateUpdateOptional.isPresent()) {
            return new GenericResponseDto<>(validateUpdateOptional.get());
        }

        var userOptional = userService.update(new UpdateUserParams(
                id,
                updateDto.firstName(),
                updateDto.lastName(),
                updateDto.location(),
                updateDto.passportId()
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

        var validateGetById = userValidation.getByIdValidate(id);
        if(validateGetById.isPresent()) {
            return new GenericResponseDto<>(validateGetById.get());
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

        var giveVoteValidate = userValidation.giveVoteValidate(userGiveVoteRequestDto);
        if(giveVoteValidate.isPresent()) {
            return new GenericResponseDto<>(giveVoteValidate.get());
        }

//        userService.update();

        return null;
    }
}

