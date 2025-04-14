package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.Defi;
import com.pfe.challenge.Service.DefiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/defis")
public class DefiController {

    @Autowired
    private DefiService defiService;

    @GetMapping
    public List<Defi> getAllDefis() {
        return defiService.getAllDefis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Defi> getDefiById(@PathVariable int id) {
        return ResponseEntity.ok(defiService.getDefiById(id));
    }

    @PostMapping
    public ResponseEntity<Defi> createDefi(@RequestBody Defi defi) {
        return ResponseEntity.status(HttpStatus.CREATED).body(defiService.createDefi(defi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Defi> updateDefi(@PathVariable int id, @RequestBody Defi defi) {
        return ResponseEntity.ok(defiService.updateDefi(id, defi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDefi(@PathVariable int id) {
        defiService.deleteDefi(id);
        return ResponseEntity.noContent().build();
    }
}

