package com.pfe.challenge.Controller;


import com.pfe.challenge.Model.Reward;
import com.pfe.challenge.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rewards")
public class RewardController {
@Autowired
 private RewardService rewardService;
    @PostMapping("/save/{challenge_id}")
    public ResponseEntity<Reward> createReward(@PathVariable String challenge_id, @RequestBody Reward reward) {
        Reward createdReward = rewardService.createReward(challenge_id, reward);
        return ResponseEntity.ok(createdReward);
    }

}
