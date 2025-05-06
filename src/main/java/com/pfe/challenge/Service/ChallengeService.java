package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository  challengeRepository ;

    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public Optional<Challenge> getChallengeById(String id) {
        return challengeRepository.findById(id);
    }

    public Optional<Challenge> getChallengeWithRewards(String id) {
        Optional<Challenge> challenge = challengeRepository.findByIdWithRewards(id);
        challenge.ifPresent(c -> {
            System.out.println("Challenge retrieved: " + c);
            System.out.println("Rewards: " + c.getRewards());
        });
        return challenge;
    }


}
