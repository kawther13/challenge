package com.pfe.challenge.Service;

import com.pfe.challenge.Model.PalierIntervalle;
import com.pfe.challenge.Model.RolePaliers;
import com.pfe.challenge.Repository.PalierIntervalleRepository;
import com.pfe.challenge.Repository.RolePalierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalierIntervalleService {

    @Autowired
    private PalierIntervalleRepository repository;

    @Autowired
    private RolePalierRepository rolePalierRepository;

    public PalierIntervalle create(Long rolePalierId, PalierIntervalle intervalle) {
        RolePaliers role = rolePalierRepository.findById(rolePalierId)
                .orElseThrow(() -> new RuntimeException("RolePalier not found"));
        intervalle.setRolePaliers(role);
        return repository.save(intervalle);
    }

    public List<PalierIntervalle> findAll() {
        return repository.findAll();
    }

    public List<PalierIntervalle> findByRolePalierId(Long id) {
        return repository.findByRolePaliersId(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PalierIntervalle update(Long id, PalierIntervalle updated) {
        return repository.findById(id).map(existing -> {
            existing.setMin(updated.getMin());
            existing.setMax(updated.getMax());
            existing.setMontant(updated.getMontant());
            return repository.save(existing);
        }).orElse(null);
    }
}

