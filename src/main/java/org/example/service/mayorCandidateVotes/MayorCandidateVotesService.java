package org.example.service.mayorCandidateVotes;

import org.example.domain.entity.MayorCandidateVotes;
import java.util.Optional;

public interface MayorCandidateVotesService {
    Optional<MayorCandidateVotes> update(Integer id);
}
