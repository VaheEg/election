package org.example.service.mayorElectionUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.MayorElection;
import org.example.domain.entity.MayorElectionUser;
import org.example.domain.entity.User;
import org.example.respository.MayorElectionRepository;
import org.example.respository.MayorElectionUserRepository;
import org.example.respository.UserRepository;
import org.example.service.mayorElectionUser.params.CreateMayorElectionUserParams;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultMayorElectionUserService implements MayorElectionUserService {

    private final MayorElectionUserRepository mayorElectionUserRepository;
    private final MayorElectionRepository mayorElectionRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<Set<MayorElectionUser>> create(CreateMayorElectionUserParams params) { //todo
        log.info("Creating mayorElectionUser for the provide params - {}", params);

        final var mayorElectionId = params.mayorElectionId();
        final var listOfUsersIds = params.usersId();
        final Optional<MayorElection> mayorElectionOptional = mayorElectionRepository.findById(mayorElectionId);

        if(mayorElectionOptional.isEmpty()) {
            return Optional.empty();
        }


        final List<Optional<User>> list = listOfUsersIds.stream().map(id -> userRepository.findById(id)).toList();
        Set<MayorElectionUser> mayorElectionUserSet = new HashSet<>();
        for(Optional<User> userOptional : list) {
            if(userOptional.isEmpty()) {
                continue;
            }
            final var savedMayorElectionUser = mayorElectionUserRepository.save(new MayorElectionUser(mayorElectionOptional.get(), userOptional.get(), true));
            mayorElectionUserSet.add(savedMayorElectionUser);
        }

        log.info("Successfully created mayorElectionUsers - {}", mayorElectionUserSet);
        return Optional.of(mayorElectionUserSet);

    }

    @Override
    public Optional<MayorElectionUser> updateCheckUserGiveVote(Integer userId, Integer mayorElectionId) {
        log.info("Updating user's give vote for the provided mayorElectionId - {} and the provided userId - {}", mayorElectionId, userId);
        final Optional<MayorElectionUser> mayorElectionUserOptional = findByUserIdAndMayorElectionId(userId, mayorElectionId);
        if(mayorElectionUserOptional.isEmpty()) {
            return Optional.empty();
        }

        final var mayorElectionUser = mayorElectionUserOptional.get();
        mayorElectionUser.setCheckGiveVote(!mayorElectionUser.getCheckGiveVote());

        final MayorElectionUser savedMayorElectionUser = mayorElectionUserRepository.save(mayorElectionUser);

        log.info("Successfully updated user's give vote, response entity - {}", mayorElectionUser);
        return Optional.of(savedMayorElectionUser);
    }

    @Override
    public Optional<MayorElectionUser> findByUserIdAndMayorElectionId(Integer userId, Integer mayorElectionId) {
        log.info("Finding mayorElectionUser for the provided mayorElectionId - {} and the provided userId -{}", mayorElectionId, userId);

        final Optional<MayorElectionUser> mayorElectionUserOptional = mayorElectionUserRepository.findByUserIdAndMayorCandidateId(userId, mayorElectionId);

        log.info("Successfully found mayorElectionUserOptional - {}", mayorElectionUserOptional);
        return mayorElectionUserOptional;
    }
}
