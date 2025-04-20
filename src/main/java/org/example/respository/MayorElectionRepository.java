package org.example.respository;

import org.example.domain.entity.MayorElection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MayorElectionRepository extends JpaRepository<MayorElection, Integer> {
}
