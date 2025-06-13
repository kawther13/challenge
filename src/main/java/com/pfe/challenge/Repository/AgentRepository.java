package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.Agent;
import com.pfe.challenge.Model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
   // List<Agent> findByChallengeId(Long challengeId);
   @Query("SELECT a FROM Agent a WHERE a.region.nom = :regionNom")
   List<Agent> findByRegionNom(@Param("regionNom") String regionNom);





}
