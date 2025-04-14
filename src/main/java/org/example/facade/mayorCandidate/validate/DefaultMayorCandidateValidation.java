package org.example.facade.mayorCandidate.validate;

import lombok.RequiredArgsConstructor;
import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;
import org.example.service.mayorCandidate.MayorCandidateService;
import org.example.service.user.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultMayorCandidateValidation implements MayorCandidateValidation {

    private final MayorCandidateService mayorCandidateService;
    private final UserService userService;

    @Override
    public Optional<Error> createValidate(Integer userId) {

        if(userId == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }


        return Optional.empty();
    }

    @Override
    public Optional<Error> getValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        return Optional.empty();
    }

    @Override
    public GenericResponseDto<Void> deleteValidate(Integer id) {

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return new GenericResponseDto<>(error);
        }

        userService.deleteById(id);

        return new GenericResponseDto<>();
    }
}
