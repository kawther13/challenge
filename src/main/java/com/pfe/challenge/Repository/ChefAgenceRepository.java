package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ChefAgence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChefAgenceRepository extends JpaRepository<ChefAgence, Long> {
    List<ChefAgence> findByChallengeIdOrderByScoreDesc(Long challengeId);
}
