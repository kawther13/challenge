package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeGagnantCommercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ListeGagnantCommercialRepository extends JpaRepository<ListeGagnantCommercial, Long> {

    @Modifying
    @Query("DELETE FROM ListeGagnantCommercial l WHERE l.challengeId = :challengeId ")
    void deleteByChallengeId(@Param("challengeId") Long challengeId);




    @Query("SELECT a FROM  ListeGagnantCommercial a WHERE a.challengeId = :challengeId ")
    List< ListeGagnantCommercial> findByChallengeId(@Param("challengeId") Long challengeId);

}
