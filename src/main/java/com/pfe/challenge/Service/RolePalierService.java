package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Challenge;
import com.pfe.challenge.Model.RolePaliers;
import com.pfe.challenge.Repository.ChallengeRepository;
import com.pfe.challenge.Repository.RolePalierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePalierService {

    @Autowired
    private RolePalierRepository rolePalierRepository;

    @Autowired
    private ChallengeRepository challengeRepository; // injecter le repo challenge

    public RolePaliers save(Long challengeId, RolePaliers rolePalier) {
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found with id " + challengeId));
        rolePalier.setChallenge(challenge);
        return rolePalierRepository.save(rolePalier);
    }

    public RolePaliers update(Long id, Long challengeId, RolePaliers updated) {
        RolePaliers existing = rolePalierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolePaliers not found with id " + id));

        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found with id " + challengeId));

        existing.setRole(updated.getRole());
        existing.setTypeGain(updated.getTypeGain());
        existing.setPalier(updated.getPalier());
        existing.setClassement(updated.getClassement());
        existing.setChallenge(challenge);  // assigner challenge ici
        return rolePalierRepository.save(existing);
    }

    public void delete(Long id) {
        rolePalierRepository.deleteById(id);
    }

    public List<RolePaliers> findAll() {
        return rolePalierRepository.findAll();
    }

    public RolePaliers findById(Long id) {
        return rolePalierRepository.findById(id).orElse(null);
    }

    public List<RolePaliers> findByChallengeId(Long challengeId) {
        return rolePalierRepository.findByChallengeId(challengeId);
    }

}
