package org.example.domain.request.user;

import java.time.LocalDate;

public record UserCreateRequestDto(
        String firstName,
        String lastName,
        String location,
        LocalDate yearOfBirth,
        String socialSecurityNumber,
        String password
) {
}
