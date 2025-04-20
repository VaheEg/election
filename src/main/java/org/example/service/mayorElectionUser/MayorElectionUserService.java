package org.example.service.mayorElectionUser;

import org.example.domain.entity.MayorElectionUser;
import org.example.service.mayorElectionUser.params.MayorElectionUserResponseParams;

import java.util.List;
import java.util.Optional;

public interface MayorElectionUserService {
    List<MayorElectionUser> create(MayorElectionUserResponseParams params);
    Optional<MayorElectionUser> checkUserGiveVotes();
    Optional<MayorElectionUser> findByUserIdAndMayorElectionId(Integer userId, Integer mayorElectionId);
}
