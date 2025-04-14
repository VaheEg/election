package org.example.respository;

import org.example.domain.entity.MayorCandidateVotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MayorCandidateVotesRepository extends JpaRepository<MayorCandidateVotes, Integer> {
}
