package org.example.respository;

import org.example.domain.entity.MayorElectionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MayorElectionUserRepository extends JpaRepository<MayorElectionUser, Integer> {

    @Query(value = "SELECT * FROM MayorElectionUser WHERE user_id = ?1 and mayor_election_id.mayorElection = ?2",
           nativeQuery = true
    )
    Optional<MayorElectionUser> findByUserIdAndMayorCandidateId(Integer userId, Integer mayorCandidateId);
}

