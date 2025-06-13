package com.pfe.challenge.Controller;


import com.pfe.challenge.Model.*;

import com.pfe.challenge.Service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

/********cred challenge*******/
    @PostMapping(value = "/save")
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallengeWithRewards(@PathVariable String id) {
        return challengeService.getChallengeWithRuless(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("all/{id}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable Long id) {
        return challengeService.getallcchallenge(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long Id) {
        challengeService.deletechallenge(Id);
        return ResponseEntity.ok("challenge supprimée avec succès.");
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<Challenge> updateRule(@PathVariable Long Id, @RequestBody Challenge challenge) {
        Challenge updated = challengeService.updatechalle(Id,challenge);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }
/*************************************************************************************/
   /** @PostMapping("/{id}/traiter-gains")
    public ResponseEntity<String> traiterGains(@PathVariable Long id) {
        challengeService.traiterGainsPourChallenge(id);
        return ResponseEntity.ok("Traitement des gains terminé.");
    }**/

   /** @GetMapping("all")
    public List<ClassementAgent> getChallenge() {
        return challengeService.getclassement();

    }**/




    /************************  get les participant******/
    @GetMapping("/{id}/commercants")
    public List<Commercant> getCommercants(@PathVariable Long id) {
        return challengeService.getCommercantsByChallenge(id);
    }

    @GetMapping("/{id}/agences")
    public List<Agence> getAgences(@PathVariable Long id) {
        return challengeService.getAgencesByChallenge(id);
    }

    @GetMapping("/{id}/regions")
    public List<Region> getRegions(@PathVariable Long id) {
        return challengeService.getRegionsByChallenge(id);
    }

    @GetMapping("/{challengeId}/agents")
    public ResponseEntity<List<Agent>> getAgentsByChallenge(@PathVariable Long challengeId) {
        List<Agent> agents = challengeService.getAgentsByChallenge(challengeId);
        return ResponseEntity.ok(agents);
    }
/*******************************************************/

}
