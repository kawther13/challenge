package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeGagnantChefAgence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ListeGagnantChefAgenceRepository extends JpaRepository<ListeGagnantChefAgence, Long> {

    @Modifying
    @Query("DELETE FROM ListeGagnantChefAgence l WHERE l.challengeId = :challengeId ")
    void deleteByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT a FROM ListeGagnantChefAgence a WHERE a.challengeId = :challengeId ")
    List<ListeGagnantChefAgence> findByChallengeId(@Param("challengeId") Long challengeId);

}
