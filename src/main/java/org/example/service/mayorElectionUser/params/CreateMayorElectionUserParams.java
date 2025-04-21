package org.example.service.mayorElectionUser.params;

import java.util.List;

public record CreateMayorElectionUserParams(
        Integer mayorElectionId,
        List<Integer> usersId
) {
}
