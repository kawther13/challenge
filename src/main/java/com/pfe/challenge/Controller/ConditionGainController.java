package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.ConditionGain;
import com.pfe.challenge.Service.ConditionGainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conditions-gain")
@CrossOrigin(origins = "http://localhost:4200")
public class ConditionGainController {

    @Autowired
    private ConditionGainService conditionGainService;

    // Get all
    @GetMapping
    public List<ConditionGain> getAllConditions() {
        return conditionGainService.getAllConditions();
    }

    // Get by ID
    @GetMapping("/{id}")
    public ConditionGain getConditionById(@PathVariable Long id) {
        return conditionGainService.getConditionById(id)
                .orElseThrow(() -> new RuntimeException("Condition not found"));
    }

    // Get by Challenge
    @GetMapping("/challenge/{challengeId}")
    public List<ConditionGain> getConditionsByChallenge(@PathVariable Long challengeId) {
        return conditionGainService.getConditionsByChallenge(challengeId);
    }

    // Create
    @PostMapping("/challenge/{challengeId}")
    public ConditionGain createCondition(@PathVariable Long challengeId, @RequestBody ConditionGain conditionGain) {
        return conditionGainService.createCondition(challengeId, conditionGain);
    }

    // Update
    @PutMapping("/{id}")
    public ConditionGain updateCondition(@PathVariable Long id, @RequestBody ConditionGain conditionGain) {
        return conditionGainService.updateCondition(id, conditionGain);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteCondition(@PathVariable Long id) {
        conditionGainService.deleteCondition(id);
    }
}