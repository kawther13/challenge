package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;

import com.pfe.challenge.Model.Rule;
import com.pfe.challenge.Repository.ChallengeRepository;
import com.pfe.challenge.Repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {
    @Autowired
    private ChallengeRepository challengeRepository;
    @Autowired
    private RuleRepository ruleRepository;




    public Rule createrule (Long challengeId, Rule rule) {
        System.out.println("Challenge ID: " + challengeId);
        System.out.println("Rule: " + rule);
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));

        rule.setChallenge(challenge);
        return ruleRepository.save(rule);
    }


    public Rule updateRule(Long ruleId, Rule updatedRule) {
        Rule rule = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new RuntimeException("Rule non trouvée"));

        rule.setContractType(updatedRule.getContractType());
        rule.setTransactionNature(updatedRule.getTransactionNature());
        rule.setPackType(updatedRule.getPackType());



        return ruleRepository.save(rule);
    }

    public void deleteRule(Long ruleId) {
        ruleRepository.deleteById(ruleId);
    }

    public  List <Rule> getAll  (Long id)
    {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));
        List<Rule> rules=challenge.getRules();
        return  rules;
    }

}
