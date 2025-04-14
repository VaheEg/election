package org.example.service.mayorCandidateVotes;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.MayorCandidateVotes;
import org.example.respository.MayorCandidateVotesRepository;
import org.example.service.mayorCandidate.MayorCandidateService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultMayorCandidateVotesService implements MayorCandidateVotesService {

    private final MayorCandidateVotesRepository mayorCandidateVotesRepository;
    private final MayorCandidateService mayorCandidateService;

    @Override
    public Optional<MayorCandidateVotes> update(Integer id) {

        Optional<MayorCandidateVotes> mayorCandidateVotesOptional = mayorCandidateVotesRepository.findById(id);
        MayorCandidateVotes mayorCandidateVotes = mayorCandidateVotesOptional.get();

        mayorCandidateVotes.setVotesCount(mayorCandidateVotes.getVotesCount() + 1);
        return Optional.empty();
    }
}
