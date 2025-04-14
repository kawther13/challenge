package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Defi;
import com.pfe.challenge.Repository.DefiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefiService {

    @Autowired
    private DefiRepository defiRepository;

    // Récupérer tous les défis
    public List<Defi> getAllDefis() {
        return defiRepository.findAll();
    }

    // Récupérer un défi par son ID
    public Defi getDefiById(int id) {
        return defiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Défi non trouvé avec id : " + id));
    }

    // Créer un nouveau défi
    public Defi createDefi(Defi defi) {
        return defiRepository.save(defi);
    }

    // Mettre à jour un défi
    public Defi updateDefi(int id, Defi updatedDefi) {
        Defi existing = getDefiById(id);

        existing.setDate_debut(updatedDefi.getDate_debut());
        existing.setDate_fin(updatedDefi.getDate_fin());
        existing.setConcernes(updatedDefi.getConcernes());
        existing.setType_contrat(updatedDefi.getType_contrat());
        existing.setNombre_contrat_min(updatedDefi.getNombre_contrat_min());
        return defiRepository.save(existing);
    }

    // Supprimer un défi
    public void deleteDefi(int id) {
        defiRepository.deleteById(id);
    }
}