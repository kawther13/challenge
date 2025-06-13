package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.RolePaliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePalierRepository extends JpaRepository<RolePaliers, Long> {
    @Query("SELECT r FROM RolePaliers r WHERE r.challenge.id = :challengeId")
    List<RolePaliers> findByChallengeId(@Param("challengeId") Long challengeId);

}

