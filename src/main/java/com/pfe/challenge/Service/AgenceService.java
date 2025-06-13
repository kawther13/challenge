package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Agence;
import com.pfe.challenge.Repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    public Optional<Agence> getAgenceById(Long id) {
        return agenceRepository.findById(id);
    }

    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Agence updateAgence(Long id, Agence updatedAgence) {
        return agenceRepository.findById(id).map(agence -> {
            agence.setNom(updatedAgence.getNom());
            agence.setRegion(updatedAgence.getRegion());
            return agenceRepository.save(agence);
        }).orElse(null);
    }

    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }
}
