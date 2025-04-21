package org.example.service.user.params;

import java.time.LocalDate;
import java.util.Date;

public record CreateUserParams(
        String firstName,
        String lastName,
        LocalDate yearOfBirth,
        String location,
        String socialSecurityNumber,
        String password
) {

}
