package org.example.service.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.User;
import org.example.respository.UserRepository;
import org.example.service.user.params.CreateUserParams;
import org.example.service.user.params.UpdateUserParams;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    //todo add logs

    @Override
    public User create(CreateUserParams params) {

        final var user = new User(
                params.firstName(),
                params.lastName(),
                params.yearOfBirth(),
                params.location(),
                params.socialSecurityNumber(),
                params.password()
        );

        return userRepository.save(user);
    }

    @Override
    public Optional<User> update(UpdateUserParams params) {

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

        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> getById(Integer id) {

        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

        userRepository.deleteById(id);
    }
}
