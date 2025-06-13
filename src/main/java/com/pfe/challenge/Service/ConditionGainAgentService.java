package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Model.ConditionGainAgent;
import com.pfe.challenge.Model.Rule;
import com.pfe.challenge.Repository.ChallengeRepository;
import com.pfe.challenge.Repository.ConditionGainAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionGainAgentService {


    @Autowired
    private ChallengeRepository challengeRepository;
    @Autowired
    private ConditionGainAgentRepository conditionGainAgentRepository;

    public ConditionGainAgent creatercondition (long challengeId, ConditionGainAgent conditionGainAgent) {
        System.out.println("Challenge ID: " + challengeId);
        System.out.println("Rule: " + conditionGainAgent);
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));

        conditionGainAgent.setChallenge(challenge);
        return  conditionGainAgentRepository.save(conditionGainAgent);
    }


    public ConditionGainAgent updateCondition_agent(Long id, ConditionGainAgent updatedCondit) {
        ConditionGainAgent existingcondition = conditionGainAgentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("condition not found"));
        existingcondition.setNbr_contrat(updatedCondit.getNbr_contrat());
        existingcondition.setPrime_encaissé(updatedCondit.getPrime_encaissé());
        return conditionGainAgentRepository.save(existingcondition);
    }

    public void deleteCondition(Long Id) {
        conditionGainAgentRepository.deleteById(Id);
    }
}
