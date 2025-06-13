package com.pfe.challenge.Service;

import com.pfe.challenge.Model.PalierClassement;
import com.pfe.challenge.Model.RolePaliers;
import com.pfe.challenge.Repository.PalierClassementRepository;
import com.pfe.challenge.Repository.RolePalierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PalierClassementService {
    @Autowired
    private PalierClassementRepository palierClassementRepository;

    @Autowired
    private RolePalierRepository rolePalierRepository;

    // Création avec l'id de RolePaliers en paramètre
    public PalierClassement createWithRolePalierId(Long rolePalierId, PalierClassement palierClassement) {
        RolePaliers rolePaliers = rolePalierRepository.findById(rolePalierId)
                .orElseThrow(() -> new RuntimeException("RolePalier not found with id " + rolePalierId));

        palierClassement.setRolePaliers(rolePaliers);
        return palierClassementRepository.save(palierClassement);
    }

    public PalierClassement update(Long id, PalierClassement updated) {
        return palierClassementRepository.findById(id)
                .map(existing -> {
                    existing.setNbr(updated.getNbr());
                    existing.setMontant(updated.getMontant());
                    existing.setRolePaliers(updated.getRolePaliers());
                    return palierClassementRepository.save(existing);
                }).orElse(null);
    }

    public void delete(Long id) {
        palierClassementRepository.deleteById(id);
    }

    public PalierClassement getById(Long id) {
        return palierClassementRepository.findById(id).orElse(null);
    }

    public List<PalierClassement> getAll() {
        return palierClassementRepository.findAll();
    }

    public List<PalierClassement> findByRolePaliersId(Long rolePalierId) {
        return palierClassementRepository.findByRolePaliersId(rolePalierId);
    }
}
