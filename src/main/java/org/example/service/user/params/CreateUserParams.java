package org.example.service.user.params;

import java.time.LocalDate;

public record CreateUserParams(
        String firstName,
        String lastName,
        LocalDate yearOfBirth,
        String location,
        String socialSecurityNumber,
        String password
) {

}
