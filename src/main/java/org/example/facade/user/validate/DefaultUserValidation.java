package org.example.facade.user.validate;

import lombok.RequiredArgsConstructor;
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
import java.time.ZoneId;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserValidation implements UserValidation {

    private final UserService userService;
    private final MayorElectionUserService mayorElectionUserService;

    @Override
    public final Optional<Error> creteRequestDtoValidate(UserCreateRequestDto params) {

        if(params.firstName() == null || !RegexUtils.NAME_PATTERN.matcher(params.firstName()).matches()) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("First Name must not be null");
            return Optional.of(error);
        }

        if(params.lastName() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Last Name must not be null");
            return Optional.of(error);
        }

        if(params.yearOfBirth() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Age must not be null");
            return Optional.of(error);
        }

        if(params.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        if(params.socialSecurityNumber() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Passport id must not be null");
            return Optional.of(error);
        }

        if(params.password() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Password must not be null");
        }

        return Optional.empty();
    }

    @Override
    public Optional<Error> updateRequestDtoValidate(UserUpdateRequestDto params, Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        if(params.firstName() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("First Name must not be null");
            return Optional.of(error);
        }

        if(params.lastName() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Last Name must not be null");
            return Optional.of(error);
        }

        if(params.location() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Location must not be null");
            return Optional.of(error);
        }

        if(params.socialSecurityNumber() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Social security number must not be null");
            return Optional.of(error);
        }

        if(params.password() == null) {
            Error error = Error.FILED_IS_NULL;
            error.setMessage("Password must not be null");
        }

        return Optional.empty();
    }

    @Override
    public Optional<Error> getByIdValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        return Optional.empty();
    }

    @Override
    public GenericResponseDto<Void> deleteByIdValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return new GenericResponseDto<>(error); //todo watch again
        }

        userService.deleteById(id);

        return new GenericResponseDto<>();
    }

    @Override
    public Optional<Error> giveVoteValidate(UserGiveVoteRequestDto userGiveVoteRequestDto) { //todo should i to get id from front and check is the age > 18 or at once get dateOfBirth from front
                                                                                             //todo should i check userGiveVoteRequestDto == null?
        if(userGiveVoteRequestDto.userId() == null) {
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
        var yearOfBirthUser = user.getDateOfBirth();

        LocalDate localDate = yearOfBirthUser.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //todo change Date to LocalDAte

        if(Period.between(localDate, LocalDate.now()).getYears() < 18 ) {
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
            Error error = Error.USER_ALREADY_VOTED;                  //todo why i need polling station if everything is online ???????
            return Optional.of(error);
        }

        return Optional.empty();
    }
}
