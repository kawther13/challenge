package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/challenges")
public class ChallengeController {

      @Autowired
      private ChallengeService challengeService;
    @PostMapping(value = "/save")
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallengeWithRewards(@PathVariable String id) {
        return challengeService.getChallengeWithRewards(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}