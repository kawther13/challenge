package com.pfe.challenge.Service;

import com.pfe.challenge.Model.SalesTransaction;
import com.pfe.challenge.Repository.SalesTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesTransactionService {

    @Autowired
    private SalesTransactionRepository repository;

    public List<SalesTransaction> getAll() {
        return repository.findAll();
    }

    public SalesTransaction getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public SalesTransaction save(SalesTransaction transaction) {
        return repository.save(transaction);
    }

    public SalesTransaction update(Long id, SalesTransaction updatedTransaction) {
        SalesTransaction existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(updatedTransaction.getNom());
            existing.setSellerRole(updatedTransaction.getSellerRole());
            //existing.setTypeContrat(updatedTransaction.getTypeContrat());
            existing.setNbrContrat(updatedTransaction.getNbrContrat());
            existing.setPrime(updatedTransaction.getPrime());
            existing.setNomAgence(updatedTransaction.getNomAgence());
            existing.setNomRegion(updatedTransaction.getNomRegion());
            existing.setChallenge(updatedTransaction.getChallenge());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<SalesTransaction> getByChallengeId(Long challengeId) {
        return repository.findByChallengeId1(challengeId);
    }

}

