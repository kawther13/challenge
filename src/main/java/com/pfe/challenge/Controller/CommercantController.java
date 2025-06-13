package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.Commercant;
import com.pfe.challenge.Service.CommercantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commercants")

public class CommercantController {

    @Autowired
    private CommercantService commercantService;

    @GetMapping
    public List<Commercant> getAllCommercants() {
        return commercantService.getAllCommercants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commercant> getCommercantById(@PathVariable Long id) {
        return commercantService.getCommercantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commercant createCommercant(@RequestBody Commercant commercant) {
        return commercantService.createCommercant(commercant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commercant> updateCommercant(@PathVariable Long id, @RequestBody Commercant updatedCommercant) {
        Commercant commercant = commercantService.updateCommercant(id, updatedCommercant);
        if (commercant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commercant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommercant(@PathVariable Long id) {
        commercantService.deleteCommercant(id);
        return ResponseEntity.noContent().build();
    }
}
