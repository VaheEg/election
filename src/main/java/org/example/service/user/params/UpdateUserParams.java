package org.example.service.user.params;

public record UpdateUserParams(
        Integer id,
        String firstName,
        String lastName,
        String location,
        String socialSecurityNumber,
        String password
) {
}
