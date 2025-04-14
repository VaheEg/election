package org.example.service.mayorCandidate;

import org.example.domain.entity.MayorCandidate;
import org.example.service.mayorCandidate.params.CreateMayorCandidateParams;
import java.util.List;
import java.util.Optional;

public interface MayorCandidateService {
    Optional<MayorCandidate> create(CreateMayorCandidateParams params);
    Optional<MayorCandidate> getById(Integer id);
    List<MayorCandidate> getAll();
    void deleteById(Integer id);
    Optional<MayorCandidate> getByUserId(Integer userId);
}
