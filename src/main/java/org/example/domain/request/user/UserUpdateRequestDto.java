package org.example.domain.request.user;

public record UserUpdateRequestDto(
        String firstName,
        String lastName,
        String location,
        String passportId
) {
}
