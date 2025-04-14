package org.example.respository;

import org.example.domain.entity.MayorCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MayorCandidateRepository extends JpaRepository<MayorCandidate, Integer> {
    Optional<MayorCandidate> findByUserId(Integer userId);
}
