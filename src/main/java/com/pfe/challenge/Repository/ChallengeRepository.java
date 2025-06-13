package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.Challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("SELECT c FROM Challenge c LEFT JOIN FETCH c.rules WHERE c.id = :id")
    Optional<Challenge> findByIdWithRules(@Param("id") String id);
}
