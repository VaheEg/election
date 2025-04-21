package org.example.facade.user.map;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.User;
import org.example.domain.response.user.UserResponseDto;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultUserMapping implements UserMapping {
    @Override
    public UserResponseDto map(User user) {
        log.debug("Mapping user to userResponseDto for the provided user - {}", user);

        var responseDto = new UserResponseDto(
                user.getFirstName(),
                user.getLastName(),
                user.getLocation()
        );

        log.debug("Successfully mapped user to userResponseDto, response - {}", responseDto);
        return responseDto;

    }
}
