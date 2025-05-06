package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Model.Reward;
import com.pfe.challenge.Repository.ChallengeRepository;
import com.pfe.challenge.Repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
@Autowired
private ChallengeRepository challengeRepository;
    @Autowired
    private RewardRepository rewardRepository;
    public Reward createReward(String challengeId, Reward reward) {
        System.out.println("Challenge ID: " + challengeId);
        System.out.println("Reward: " + reward);
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));
        reward.setChallenge(challenge);
        return rewardRepository.save(reward);
    }
}
