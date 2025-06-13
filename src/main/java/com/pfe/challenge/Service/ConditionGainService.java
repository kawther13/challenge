package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Model.ConditionGain;
import com.pfe.challenge.Repository.ChallengeRepository;
import com.pfe.challenge.Repository.ConditionGainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConditionGainService {

    @Autowired
    private ConditionGainRepository conditionGainRepository;

    @Autowired
    private ChallengeRepository challengeRepository;

    public List<ConditionGain> getAllConditions() {
        return conditionGainRepository.findAll();
    }

    public Optional<ConditionGain> getConditionById(Long id) {
        return conditionGainRepository.findById(id);
    }

    public List<ConditionGain> getConditionsByChallenge(Long challengeId) {
        return conditionGainRepository.findByChallengeId(challengeId);
    }

    public ConditionGain createCondition(Long challengeId, ConditionGain conditionGain) {
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));
        conditionGain.setChallenge(challenge);
        return conditionGainRepository.save(conditionGain);
    }

    public ConditionGain updateCondition(Long id, ConditionGain updatedCondition) {
        return conditionGainRepository.findById(id).map(condition -> {
            condition.setRole(updatedCondition.getRole());
            condition.setNbrContrat(updatedCondition.getNbrContrat());
            condition.setPrime(updatedCondition.getPrime());
            condition.setTypeContrat(updatedCondition.getTypeContrat());
            return conditionGainRepository.save(condition);
        }).orElseThrow(() -> new RuntimeException("Condition not found"));
    }

    public void deleteCondition(Long id) {
        conditionGainRepository.deleteById(id);
    }
}