package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeGagnantAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ListeGagnantAgentRepository extends JpaRepository<ListeGagnantAgent, Long> {

    @Modifying
    @Query("DELETE FROM ListeGagnantAgent l WHERE l.challengeId = :challengeId ")
    void deleteByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT a FROM ListeGagnantAgent a WHERE a.challengeId = :challengeId ")
    List<ListeGagnantAgent> findByChallengeId(@Param("challengeId") Long challengeId);


}
