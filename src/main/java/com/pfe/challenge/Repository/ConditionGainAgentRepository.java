package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ConditionGainAgent;
import com.pfe.challenge.Model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionGainAgentRepository extends JpaRepository<ConditionGainAgent, Long> {
}
