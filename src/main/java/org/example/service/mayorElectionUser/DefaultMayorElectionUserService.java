package org.example.service.mayorElectionUser;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.MayorElection;
import org.example.domain.entity.MayorElectionUser;
import org.example.respository.MayorElectionRepository;
import org.example.respository.MayorElectionUserRepository;
import org.example.respository.UserRepository;
import org.example.service.mayorElectionUser.params.MayorElectionUserResponseParams;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultMayorElectionUserService implements MayorElectionUserService {

    private final MayorElectionUserRepository mayorElectionUserRepository;
    private final MayorElectionRepository mayorElectionRepository;
    private final UserRepository userRepository;

    @Override
    public List<MayorElectionUser> create(MayorElectionUserResponseParams params) { //todo return type

        final var usersId = params.usersId();
        final var listOfUsersIds = params.usersId();
        final Optional<MayorElection> mayorElectionOptional = mayorElectionRepository.findById(params.mayorElectionId());

        listOfUsersIds.stream().forEach(id -> {


        });

        return null;

    }

    @Override
    public Optional<MayorElectionUser> checkUserGiveVotes() {
        return Optional.empty();
    }

    @Override
    public Optional<MayorElectionUser> findByUserIdAndMayorElectionId(Integer userId, Integer mayorElectionId) {

        return mayorElectionUserRepository
                        .findByUserIdAndMayorCandidateId(userId, mayorElectionId);
    }
}
