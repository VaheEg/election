package org.example.facade.user.map;

import org.example.domain.entity.User;
import org.example.domain.response.user.UserResponseDto;

public interface UserMapping {
    UserResponseDto map(User user);

}
