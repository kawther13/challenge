package com.pfe.challenge.Controller;

import com.pfe.challenge.Service.GagnantService;
import com.pfe.challenge.Service.GainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/gains")
@CrossOrigin(origins = "http://localhost:4200")
public class GainController {

  /**  @Autowired
    private GainService gainService;

    @PostMapping("/attribuer/{challengeId}")
    public ResponseEntity<String> attribuerGains(@PathVariable Long challengeId) {
        try {
            gainService.attribuerGains(challengeId);
            return ResponseEntity.ok("Gains attribués avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur: " + e.getMessage());
        }
    }**/

  @Autowired
  private GagnantService gagnantService;


    @PostMapping("/update/{challengeId}")
    public void updateGainsManual(
            @PathVariable Long challengeId
           ) {
        gagnantService.traiterGagnantsParChallenge(challengeId);
    }
}
