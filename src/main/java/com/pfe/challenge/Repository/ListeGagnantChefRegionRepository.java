package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeGagnantChefRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ListeGagnantChefRegionRepository extends JpaRepository<ListeGagnantChefRegion, Long> {

    @Modifying
    @Query("DELETE FROM ListeGagnantAgent l WHERE l.challengeId = :challengeId ")
    void deleteByChallengeId(@Param("challengeId") Long challengeId);
    @Query("SELECT a FROM ListeGagnantChefRegion a WHERE a.challengeId = :challengeId ")
    List<ListeGagnantChefRegion> findByChallengeId(@Param("challengeId") Long challengeId);

}
