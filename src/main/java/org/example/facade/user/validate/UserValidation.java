package org.example.facade.user.validate;

import org.example.domain.request.user.UserCreateRequestDto;
import org.example.domain.request.user.UserGiveVoteRequestDto;
import org.example.domain.request.user.UserUpdateRequestDto;
import org.example.domain.response.GenericResponseDto;
import org.example.error.Error;
import java.util.Optional;

public interface UserValidation {

    Optional<Error> creteRequestDtoValidate(UserCreateRequestDto params);
    Optional<Error> updateRequestDtoValidate(UserUpdateRequestDto params, Integer id);
    Optional<Error> getByIdValidate(Integer id);
    GenericResponseDto<Void> deleteByIdValidate(Integer id);
    Optional<Error> giveVoteValidate(UserGiveVoteRequestDto userGiveVoteRequestDto);
}
