package com.pfe.challenge.Repository;

import com.pfe.challenge.Model.ListeeGagnantAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeeGagnantAgentRepository extends JpaRepository<ListeeGagnantAgent, Long> {}
