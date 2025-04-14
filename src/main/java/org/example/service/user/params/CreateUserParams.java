package org.example.service.user.params;

import java.util.Date;

public record CreateUserParams(
        String firstName,
        String lastName,
        Date yearOfBirth,
        String location,
        String passwordId
) {

}
