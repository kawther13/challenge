package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Commercant;
import com.pfe.challenge.Repository.CommercantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommercantService {

    @Autowired
    private CommercantRepository commercantRepository;

    public List<Commercant> getAllCommercants() {
        return commercantRepository.findAll();
    }

    public Optional<Commercant> getCommercantById(Long id) {
        return commercantRepository.findById(id);
    }

    public Commercant createCommercant(Commercant commercant) {
        return commercantRepository.save(commercant);
    }

    public Commercant updateCommercant(Long id, Commercant updatedCommercant) {
        return commercantRepository.findById(id).map(c -> {
            c.setNom(updatedCommercant.getNom());
            c.setAgence(updatedCommercant.getAgence());
            return commercantRepository.save(c);
        }).orElse(null);
    }

    public void deleteCommercant(Long id) {
        commercantRepository.deleteById(id);
    }
}