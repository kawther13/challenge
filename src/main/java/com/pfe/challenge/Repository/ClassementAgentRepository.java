package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ClassementAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassementAgentRepository extends JpaRepository<ClassementAgent, Long> {
    List<ClassementAgent> findByChallengeId(Long challengeId);
}
