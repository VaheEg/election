package org.example.service.mayorCandidateVotes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorCandidateVotes;
import org.example.respository.MayorCandidateVotesRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultMayorCandidateVotesService implements MayorCandidateVotesService {

    private final MayorCandidateVotesRepository mayorCandidateVotesRepository;

    @Override
    public Optional<MayorCandidateVotes> updateVotesCount(Integer mayorCandidateId) {
        log.info("Updating mayor candidate's votes count for the provided mayor candidate's id- {} ", mayorCandidateId);

        Optional<MayorCandidateVotes> mayorCandidateVotesOptional = mayorCandidateVotesRepository.findById(mayorCandidateId);
        if(mayorCandidateVotesOptional.isEmpty()) {
            return Optional.empty();
        }

        MayorCandidateVotes mayorCandidateVotes = mayorCandidateVotesOptional.get();
        mayorCandidateVotes.setVotesCount(mayorCandidateVotes.getVotesCount() + 1);

        final var savedMayorCandidate = mayorCandidateVotesRepository.save(mayorCandidateVotes);

        log.info("Successfully updated mayor candidate's votes count, mayor candidate votes - {}", savedMayorCandidate);
        return Optional.of(savedMayorCandidate);
    }
}
