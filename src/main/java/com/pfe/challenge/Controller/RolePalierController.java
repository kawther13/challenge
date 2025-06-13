package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.RolePaliers;
import com.pfe.challenge.Service.RolePalierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-paliers")

public class RolePalierController {

    @Autowired
    private RolePalierService rolePaliersService;

    // Ajouter un RolePaliers en précisant l'id du challenge
    @PostMapping("/add/{challengeId}")
    public ResponseEntity<RolePaliers> create(@PathVariable Long challengeId, @RequestBody RolePaliers rolePalier) {
        RolePaliers saved = rolePaliersService.save(challengeId, rolePalier);
        return ResponseEntity.ok(saved);
    }

    // Modifier un RolePaliers avec id + challengeId
    @PutMapping("/update/{id}/{challengeId}")
    public ResponseEntity<RolePaliers> update(@PathVariable Long id, @PathVariable Long challengeId, @RequestBody RolePaliers updated) {
        RolePaliers saved = rolePaliersService.update(id, challengeId, updated);
        return ResponseEntity.ok(saved);
    }

    // Supprimer par id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolePaliersService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Récupérer tous
    @GetMapping("/all")
    public ResponseEntity<List<RolePaliers>> getAll() {
        List<RolePaliers> list = rolePaliersService.findAll();
        return ResponseEntity.ok(list);
    }

    // Récupérer par id
    @GetMapping("/{id}")
    public ResponseEntity<RolePaliers> getById(@PathVariable Long id) {
        RolePaliers rolePalier = rolePaliersService.findById(id);
        if (rolePalier == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rolePalier);
    }

    // Récupérer tous les RolePaliers liés à un challenge donné
    @GetMapping("/by_challenge/{challengeId}")
    public ResponseEntity<List<RolePaliers>> getByChallenge(@PathVariable Long challengeId) {

        List<RolePaliers> list = rolePaliersService.findByChallengeId(challengeId);
        return ResponseEntity.ok(list);
    }


    }



