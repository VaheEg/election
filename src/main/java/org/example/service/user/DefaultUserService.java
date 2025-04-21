package org.example.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.User;
import org.example.respository.UserRepository;
import org.example.service.user.params.CreateUserParams;
import org.example.service.user.params.UpdateUserParams;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(CreateUserParams params) {
        log.info("Creating user for the provided params - {}", params);

        final var user = new User(
                params.firstName(),
                params.lastName(),
                params.yearOfBirth(),
                params.location(),
                params.socialSecurityNumber(),
                params.password()
        );

        log.info("Successfully created user - {}", user);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> update(UpdateUserParams params) {
        log.info("Updating user for the provided params - {}", params);

        var userOptional = userRepository.findById(params.id());
        if(userOptional.isEmpty()) {
            return Optional.empty();
        }
        var user = userOptional.get();

        user.setFirstName(params.firstName());
        user.setLastName(params.lastName());
        user.setLocation((params.location()));
        user.setSocialSecurityNumber(params.socialSecurityNumber());
        user.setPassword(params.password());

        final var savedUser = userRepository.save(user);

        log.info("Successfully updated user - {}", savedUser);
        return Optional.of(savedUser);
    }

    @Override
    public Optional<User> getById(Integer id) {
        log.info("Finding user for the provided id - {}", id);

        final var userOptional = userRepository.findById(id);

        log.info("User found successfully, user optional - {}", userOptional);
        return userOptional;
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting user by provided id - {}", id);

        userRepository.deleteById(id);

        log.info("Successfully deleted user");
    }
}
