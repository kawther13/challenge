package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    @Query("SELECT p FROM Participant p WHERE p.challenge.id = :challengeId")
    List<Participant> findByChallengeId(@Param("challengeId") Long challengeId);

}
