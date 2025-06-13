package com.pfe.challenge.Controller;


import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Model.Rule;

import com.pfe.challenge.Service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;
    @PostMapping("/save/{challenge_id}")
    public ResponseEntity<Rule> createRule(@PathVariable Long challenge_id, @RequestBody Rule rule) {
        Rule  createdRule  = ruleService.createrule(challenge_id, rule);
        return ResponseEntity.ok(createdRule);
    }

    @PutMapping("/update/{ruleId}")
    public ResponseEntity<Rule> updateRule(@PathVariable Long ruleId, @RequestBody Rule rule) {
        Rule updated = ruleService.updateRule(ruleId, rule);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/delete/{ruleId}")
    public ResponseEntity<String> deleteRule(@PathVariable Long ruleId) {
        ruleService.deleteRule(ruleId);
        return ResponseEntity.ok("Rule supprimée avec succès.");
    }

    @GetMapping("/rule_challenge/{id}")
    public List<Rule> getChallengePalier(@PathVariable Long id) {
        return ruleService.getAll(id);

    }

}
