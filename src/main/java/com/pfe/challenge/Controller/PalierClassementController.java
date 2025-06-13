package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.PalierClassement;
import com.pfe.challenge.Service.PalierClassementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palier-classements")

public class PalierClassementController {

    @Autowired
    private PalierClassementService palierClassementService;

    // Ajouter un PalierClassement lié à un RolePaliers via son ID
    @PostMapping("/role-palier/{rolePalierId}")
    public ResponseEntity<PalierClassement> createWithRolePalierId(
            @PathVariable Long rolePalierId,
            @RequestBody PalierClassement palierClassement) {
        PalierClassement created = palierClassementService.createWithRolePalierId(rolePalierId, palierClassement);
        return ResponseEntity.ok(created);
    }

    // Récupérer tous
    @GetMapping
    public ResponseEntity<List<PalierClassement>> getAll() {
        return ResponseEntity.ok(palierClassementService.getAll());
    }

    // Récupérer par ID
    @GetMapping("/{id}")
    public ResponseEntity<PalierClassement> getById(@PathVariable Long id) {
        PalierClassement pc = palierClassementService.getById(id);
        if (pc == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pc);
    }

    // Supprimer par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        palierClassementService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Récupérer par RolePaliers ID
    @GetMapping("/by-role-palier/{rolePalierId}")
    public ResponseEntity<List<PalierClassement>> getByRolePalierId(@PathVariable Long rolePalierId) {
        return ResponseEntity.ok(palierClassementService.findByRolePaliersId(rolePalierId));
    }
}
