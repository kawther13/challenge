package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ConditionGain;
import com.pfe.challenge.Model.GainAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GainAgentRepository extends JpaRepository<GainAgent, Long> {
}
