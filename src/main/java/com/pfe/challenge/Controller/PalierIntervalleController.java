package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.PalierIntervalle;
import com.pfe.challenge.Service.PalierIntervalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palier-intervalle")

public class PalierIntervalleController {

    @Autowired
    private PalierIntervalleService service;

    @PostMapping("/create/{rolePalierId}")
    public ResponseEntity<PalierIntervalle> create(
            @PathVariable Long rolePalierId,
            @RequestBody PalierIntervalle intervalle) {
        return ResponseEntity.ok(service.create(rolePalierId, intervalle));
    }

    @GetMapping
    public ResponseEntity<List<PalierIntervalle>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/by-role-palier/{rolePalierId}")
    public ResponseEntity<List<PalierIntervalle>> getByRolePalier(@PathVariable Long rolePalierId) {
        return ResponseEntity.ok(service.findByRolePalierId(rolePalierId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PalierIntervalle> update(@PathVariable Long id, @RequestBody PalierIntervalle updated) {
        return ResponseEntity.ok(service.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

