package com.pfe.challenge.Repository;


import com.pfe.challenge.Model.ScoreRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRuleRepository extends JpaRepository<ScoreRule, Long> {
    @Query("SELECT sr FROM ScoreRule sr WHERE sr.challenge.id = :challengeId")
    List<ScoreRule> findByChallengeId(@Param("challengeId") Long challengeId);
}
