package org.example.domain.request.user;

import java.util.Date;

public record UserCreateRequestDto(
        String firstName,
        String lastName,
        String location,
        Date yearOfBirth,
        String passportId
) {
}
