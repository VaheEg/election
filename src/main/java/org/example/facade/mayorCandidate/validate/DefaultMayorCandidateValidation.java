package org.example.facade.mayorCandidate.validate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;
import org.example.service.user.UserService;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultMayorCandidateValidation implements MayorCandidateValidation {

    private final UserService userService;

    @Override
    public Optional<Error> createValidate(Integer userId) {
        log.debug("Validating createMayorElection request by provided id - {}", userId);

        if(userId == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        log.debug("Successfully validated createMayorElection request");
        return Optional.empty();
    }

    @Override
    public Optional<Error> getByIdValidate(Integer id) {
        log.debug("Validating getMayorElectionById request by provided id - {}", id);

        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return Optional.of(error);
        }

        log.debug("Successfully validated getMayorElectionById request");
        return Optional.empty();
    }

    @Override
    public GenericResponseDto<Void> deleteValidate(Integer id) {
        log.debug("Validating deleteMayorElectionById request by provided id - {}", id);
        if(id == null) {
            Error error = Error.ID_IS_NULL;
            return new GenericResponseDto<>(error);
        }

        log.debug("Successfully validated deleteMayorElectionById request");
        userService.deleteById(id);

        return new GenericResponseDto<>();
    }
}
