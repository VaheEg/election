package org.example.facade.mayorCandidate.validate;

import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;
import java.util.Optional;

public interface MayorCandidateValidation {
    Optional<Error> createValidate(Integer userId);
    Optional<Error> getValidate(Integer id);
    GenericResponseDto<Void> deleteValidate(Integer Id);
}
