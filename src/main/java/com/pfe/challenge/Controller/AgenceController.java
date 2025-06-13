package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.Agence;
import com.pfe.challenge.Service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")

public class AgenceController {

    @Autowired
    private AgenceService agenceService;

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.getAllAgences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agence createAgence(@RequestBody Agence agence) {
        return agenceService.createAgence(agence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence updatedAgence) {
        Agence agence = agenceService.updateAgence(id, updatedAgence);
        if (agence == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        agenceService.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }
}
