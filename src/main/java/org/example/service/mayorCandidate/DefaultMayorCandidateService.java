package org.example.service.mayorCandidate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorCandidate;
import org.example.respository.MayorCandidateRepository;
import org.example.respository.UserRepository;
import org.example.service.mayorCandidate.params.CreateMayorCandidateParams;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultMayorCandidateService implements MayorCandidateService {

    private final MayorCandidateRepository mayorCandidateRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<MayorCandidate> create(CreateMayorCandidateParams params) {
        log.info("Creating mayor candidate for the provided params - {}", params);

        var userOptional = userRepository.findById(params.userId());
        if(userOptional.isEmpty()) {
            return Optional.empty();
        }
        var mayorCandidate = new MayorCandidate(userOptional.get());

        log.info("Successfully created mayor candidate - {}", mayorCandidate);
        return Optional.of(mayorCandidateRepository.save(mayorCandidate));
    }

    @Override
    public Optional<MayorCandidate> getById(Integer id) {
        log.info("Finding mayor candidate for the provided id - {}", id); //todo

        final Optional<MayorCandidate> mayorCandidateOptional = mayorCandidateRepository.findById(id);

        log.info("Mayor candidate successfully found, mayor candidate optional - {}", mayorCandidateOptional);
        return mayorCandidateOptional;
    }

    @Override
    public List<MayorCandidate> getAll() {
        log.info("Getting all mayor candidates");

        final var mayorCandidates = mayorCandidateRepository.findAll();

        log.info("All candidates successfully found - {}", mayorCandidates);
        return mayorCandidates;
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting mayor candidates by the provided id - {}", id);

        mayorCandidateRepository.deleteById(id);

        log.info("Mayor candidate successfully deleted");
    }

    @Override
    public Optional<MayorCandidate> getByUserId(Integer userId) {
        log.info("Getting mayor candidate by the provided user id - {}", userId);

        final Optional<MayorCandidate> mayorCandidateOptional = mayorCandidateRepository.findByUserId(userId);

        log.info("Mayor candidate successfully found for the provided user id, mayor candidate optional - {}", mayorCandidateOptional);
        return mayorCandidateOptional;
    }
}
