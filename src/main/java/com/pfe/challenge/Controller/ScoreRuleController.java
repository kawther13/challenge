package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.ScoreRule;
import com.pfe.challenge.Service.ScoreRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score-rules")
@CrossOrigin(origins = "http://localhost:4200")
public class ScoreRuleController {

    @Autowired
    private ScoreRuleService scoreRuleService;

    @PostMapping("/{challengeId}")
    public ResponseEntity<ScoreRule> createScoreRule(@RequestBody ScoreRule scoreRule,
                                                     @PathVariable Long challengeId) {
        ScoreRule created = scoreRuleService.addScoreRule(scoreRule, challengeId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/challenge/{challengeId}")
    public ResponseEntity<List<ScoreRule>> getScoreRulesByChallenge(@PathVariable Long challengeId) {
        return ResponseEntity.ok(scoreRuleService.getScoreRulesByChallengeId(challengeId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScoreRule> updateScoreRule(@PathVariable Long id, @RequestBody ScoreRule updatedScoreRule) {
        return ResponseEntity.ok(scoreRuleService.updateScoreRule(id, updatedScoreRule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScoreRule(@PathVariable Long id) {
        scoreRuleService.deleteScoreRule(id);
        return ResponseEntity.noContent().build();
    }
}

