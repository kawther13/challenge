package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.ListeGagnantAgent;
import com.pfe.challenge.Model.ListeGagnantChefAgence;
import com.pfe.challenge.Model.ListeGagnantChefRegion;
import com.pfe.challenge.Model.ListeGagnantCommercial;
import com.pfe.challenge.Repository.ListeGagnantAgentRepository;
import com.pfe.challenge.Repository.ListeGagnantChefAgenceRepository;
import com.pfe.challenge.Repository.ListeGagnantChefRegionRepository;
import com.pfe.challenge.Repository.ListeGagnantCommercialRepository;
import com.pfe.challenge.Service.GagnantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gagnants")
@CrossOrigin(origins = "http://localhost:4200")
public class GagnantController {
    @Autowired
    private GagnantService gagnantService;
    @Autowired
    private ListeGagnantAgentRepository agentRepo;
    @Autowired
    private ListeGagnantCommercialRepository commercialRepo;
    @Autowired
    private ListeGagnantChefAgenceRepository chefAgenceRepo;
    @Autowired
    private ListeGagnantChefRegionRepository chefRegionRepo;

    @GetMapping("/agent/{challengeId}")
    public List<ListeGagnantAgent> getGagnantsAgentParDate(@PathVariable Long challengeId) {
        return agentRepo.findByChallengeId(challengeId);
    }

    @GetMapping("/commercial/{challengeId}")
    public List<ListeGagnantCommercial> getGagnantsCommercialParDate(@PathVariable Long challengeId) {
        return commercialRepo.findByChallengeId(challengeId);
    }

    @GetMapping("/chef-agence/{challengeId}")
    public List<ListeGagnantChefAgence> getGagnantsChefAgenceParDate(@PathVariable Long challengeId) {
        return chefAgenceRepo.findByChallengeId(challengeId);
    }

    @GetMapping("/date/{date}/chef-region/{challengeId}")
    public List<ListeGagnantChefRegion> getGagnantsChefRegionParDate(@PathVariable Long challengeId) {
        return chefRegionRepo.findByChallengeId(challengeId);
    }

    @GetMapping("/{role}/{challengeId}")
    public ResponseEntity<?> getGagnantsParRoleEtChallenge(
            @PathVariable String role,
            @PathVariable Long challengeId) {

        switch (role.toLowerCase()) {
            case "agent":
                return ResponseEntity.ok(agentRepo.findByChallengeId(challengeId));

            case "commercant":
                return ResponseEntity.ok(commercialRepo.findByChallengeId(challengeId));

            case "chef_agence":
                return ResponseEntity.ok(chefAgenceRepo.findByChallengeId(challengeId));

            case "chef_region":
                return ResponseEntity.ok(chefRegionRepo.findByChallengeId(challengeId));

            default:
                return ResponseEntity.badRequest().body("Rôle non reconnu: " + role);
        }
    }

    @PostMapping("/update/{challengeId}")
    public void updateGainsManual(
            @PathVariable Long challengeId
    ) {
        gagnantService.traiterGagnantsParChallenge(challengeId);
    }
}



