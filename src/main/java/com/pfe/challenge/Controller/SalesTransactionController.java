package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.SalesTransaction;
import com.pfe.challenge.Service.SalesTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class SalesTransactionController {

    @Autowired
    private SalesTransactionService service;

    @GetMapping
    public List<SalesTransaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesTransaction> getById(@PathVariable Long id) {
        SalesTransaction transaction = service.getById(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public SalesTransaction create(@RequestBody SalesTransaction transaction) {
        return service.save(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesTransaction> update(@PathVariable Long id, @RequestBody SalesTransaction updatedTransaction) {
        SalesTransaction updated = service.update(id, updatedTransaction);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/challenge/{challengeId}")
    public List<SalesTransaction> getByChallengeId(@PathVariable Long challengeId) {
        return service.getByChallengeId(challengeId);
    }

}

