package org.example.service.mayorCandidate;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.MayorCandidate;
import org.example.respository.MayorCandidateRepository;
import org.example.respository.UserRepository;
import org.example.service.mayorCandidate.params.CreateMayorCandidateParams;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultMayorCandidateService implements MayorCandidateService {

    private final MayorCandidateRepository mayorCandidateRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<MayorCandidate> create(CreateMayorCandidateParams params) {

        var userOptional = userRepository.findById(params.userId());
        if(userOptional.isEmpty()) {
            return Optional.empty();
        }
        var mayorCandidate = new MayorCandidate(userOptional.get());

        return Optional.of(mayorCandidateRepository.save(mayorCandidate));
    }

    @Override
    public Optional<MayorCandidate> getById(Integer id) {

        return mayorCandidateRepository.findById(id);
    }

    @Override
    public List<MayorCandidate> getAll() {

        return mayorCandidateRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        mayorCandidateRepository.deleteById(id);
    }

    @Override
    public Optional<MayorCandidate> getByUserId(Integer userId) {

        return mayorCandidateRepository.findByUserId(userId);
    }
}
