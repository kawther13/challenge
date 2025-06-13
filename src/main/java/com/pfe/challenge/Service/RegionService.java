package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Region;
import com.pfe.challenge.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Optional<Region> getRegionById(Long id) {
        return regionRepository.findById(id);
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region updateRegion(Long id, Region updatedRegion) {
        return regionRepository.findById(id).map(region -> {
            region.setNom(updatedRegion.getNom());
            // Vous pouvez mettre à jour agences/agents ici si nécessaire
            return regionRepository.save(region);
        }).orElse(null);
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }
}