package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Model.ScoreRule;
import com.pfe.challenge.Repository.ChallengeRepository;
import com.pfe.challenge.Repository.ScoreRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreRuleService {

    @Autowired
    private ScoreRuleRepository scoreRuleRepository;

    @Autowired
    private ChallengeRepository challengeRepository;

    public ScoreRule addScoreRule(ScoreRule scoreRule, Long challengeId) {
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));

        scoreRule.setChallenge(challenge);
        return scoreRuleRepository.save(scoreRule);
    }

    public List<ScoreRule> getScoreRulesByChallengeId(Long challengeId) {
        return scoreRuleRepository.findByChallengeId(challengeId);
    }

    public ScoreRule updateScoreRule(Long id, ScoreRule updatedScoreRule) {
        ScoreRule existing = scoreRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScoreRule not found"));

        existing.setScoreType(updatedScoreRule.getScoreType());
        existing.setContractType(updatedScoreRule.getContractType());
        existing.setPackType(updatedScoreRule.getPackType());
        existing.setRevenueUnit(updatedScoreRule.getRevenueUnit());
        existing.setPoints(updatedScoreRule.getPoints());

        return scoreRuleRepository.save(existing);
    }

    public void deleteScoreRule(Long id) {
        scoreRuleRepository.deleteById(id);
    }
}

