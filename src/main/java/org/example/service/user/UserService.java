package org.example.service.user;

import org.example.domain.entity.User;
import org.example.service.user.params.CreateUserParams;
import org.example.service.user.params.UpdateUserParams;

import java.util.Optional;

public interface UserService {
    User create(CreateUserParams params);
    Optional<User> update(UpdateUserParams params);
    Optional<User> getById(Integer id);
    void deleteById(Integer id);

}
