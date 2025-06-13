package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.Rule;
import com.pfe.challenge.Model.SalesTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, Long> {

    @Query("SELECT t FROM SalesTransaction t WHERE t.challenge.id = :challengeId ")
    List<SalesTransaction> findByChallengeId(@Param("challengeId") Long challengeId);

    @Query("SELECT t FROM SalesTransaction t WHERE t.challenge.id = :challengeId")
    List<SalesTransaction> findByChallengeId1(@Param("challengeId") Long challengeId);


}
