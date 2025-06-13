package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ChefRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChefRegionRepository extends JpaRepository<ChefRegion, Long> {
    List<ChefRegion> findByChallengeIdOrderByScoreDesc(Long challengeId);
}
