package org.example.facade.user.validate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorElectionUser;
import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;
import org.example.service.mayorElectionUser.MayorElectionUserService;
import org.example.service.user.UserService;
import org.example.utils.RegexUtils;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultUserValidation implements UserValidation {

    private final UserService userService;
    private final MayorElectionUserService mayorElectionUserService;

    @Override
    public final Optional<Error> creteRequestDtoValidate(UserCreateRequestDto createDto) {
        log.debug("Validating createUser requestDto for the provided createDto - {}", createDto);

        if(createDto.firstName() == null || !RegexUtils.NAME_PATTERN.matcher(createDto.firstName()).matches()) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("First Name must not be null");
            return Optional.of(error);
        }

        if(createDto.lastName() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Last Name must not be null");
            return Optional.of(error);
        }

        if(createDto.yearOfBirth() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Age must not be null");
            return Optional.of(error);
        }

        if(createDto.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        if(createDto.socialSecurityNumber() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Passport id must not be null");
            return Optional.of(error);
        }

        if(createDto.password() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Password must not be null");
            return Optional.of(error);
        }

        log.debug("Successfully validated createUser requestDto");
        return Optional.empty();
    }

    @Override
    public Optional<Error> updateRequestDtoValidate(UserUpdateRequestDto updateDto, Integer id) {
        log.debug("Validating updateUser requestDto for the provided updateDto - {} and the provided user's id - {}", updateDto, id);

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        if(updateDto.firstName() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("First Name must not be null");
            return Optional.of(error);
        }

        if(updateDto.lastName() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Last Name must not be null");
            return Optional.of(error);
        }

        if(updateDto.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        if(updateDto.socialSecurityNumber() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Social security number must not be null");
            return Optional.of(error);
        }

        if(updateDto.password() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Password must not be null");
        }

        log.debug("Successfully validated updateUser requestDto");
        return Optional.empty();
    }

    @Override
    public Optional<Error> getByIdValidate(Integer id) {
        log.debug("Validating getUserById request by the provided id - {}", id);

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        log.debug("Successfully validated getUserById request");
        return Optional.empty();
    }

    @Override
    public GenericResponseDto<Void> deleteByIdValidate(Integer id) {
        log.debug("Validating deleteUserById request by the provided id - {}", id);

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return new GenericResponseDto<>(error);
        }

        log.debug("Successfully validated deleteUserById request");
        userService.deleteById(id);

        return new GenericResponseDto<>();
    }

    @Override
    public Optional<Error> giveVoteValidate(UserGiveVoteRequestDto userGiveVoteRequestDto) {
        log.debug("Validating userGiveVote requestDto for the provided requestDto - {}", userGiveVoteRequestDto);

        if(userGiveVoteRequestDto.userId() == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        if(userGiveVoteRequestDto.mayorElectionId() == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        if(userGiveVoteRequestDto.mayorCandidateId() == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        var userOptional = userService.getById(userGiveVoteRequestDto.userId());
        if(userOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("User not found");
            return Optional.of(error);
        }
        var user = userOptional.get();

        if(Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < 18 ) {
            Error error = Error.USER_AGE_IS_LESS_THEN_18;
            return Optional.of(error);
        }

        final Optional<MayorElectionUser> mayorElectionUserOptional = mayorElectionUserService
                .findByUserIdAndMayorElectionId(userGiveVoteRequestDto.userId(),
                                                userGiveVoteRequestDto.mayorCandidateId());

        if(mayorElectionUserOptional.isEmpty()) {
            Error error = Error.NOT_FOUND;
            error.setMessage("MayorElectionUser not found");
            return Optional.of(error);
        }

        if(!mayorElectionUserOptional.get().getCheckGiveVote()) {
            Error error = Error.USER_ALREADY_VOTED;
            return Optional.of(error);
        }

        log.debug("Successfully validated userGiveVote requestDto");
        return Optional.empty();
    }
}
