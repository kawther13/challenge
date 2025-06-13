package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ConditionGain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionGainRepository extends JpaRepository<ConditionGain, Long> {
    @Query("SELECT c FROM ConditionGain c WHERE c.challenge.id = :challengeId")
    List<ConditionGain> findByChallengeId(@Param("challengeId") Long challengeId);


}
