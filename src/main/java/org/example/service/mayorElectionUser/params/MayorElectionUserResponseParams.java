package org.example.service.mayorElectionUser.params;

import java.util.List;

public record MayorElectionUserResponseParams(
        Integer mayorElectionId,
        List<Integer> usersId
) {
}
