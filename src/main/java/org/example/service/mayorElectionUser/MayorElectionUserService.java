package org.example.service.mayorElectionUser;

import org.example.domain.entity.MayorElectionUser;
import org.example.service.mayorElectionUser.params.CreateMayorElectionUserParams;
import java.util.Optional;
import java.util.Set;

public interface MayorElectionUserService {
    Optional<Set<MayorElectionUser>> create(CreateMayorElectionUserParams params);
    Optional<MayorElectionUser> updateCheckUserGiveVote(Integer userId, Integer mayorElectionId);
    Optional<MayorElectionUser> findByUserIdAndMayorElectionId(Integer userId, Integer mayorElectionId);
}
