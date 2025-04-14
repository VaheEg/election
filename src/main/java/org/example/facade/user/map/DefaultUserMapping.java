package org.example.facade.user.map;

import org.example.domain.entity.User;
import org.example.domain.response.user.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserMapping implements UserMapping {
    @Override
    public UserResponseDto map(User user) {
        return new UserResponseDto(
                user.getFirstName(),
                user.getLastName(),
                user.getLocation());
    }
}
