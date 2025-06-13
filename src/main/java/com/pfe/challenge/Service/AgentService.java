package com.pfe.challenge.Service;

import com.pfe.challenge.Model.Agent;
import com.pfe.challenge.Model.Region;
import com.pfe.challenge.Repository.AgentRepository;
import com.pfe.challenge.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private RegionRepository regionRepository;
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }

    // à créer si pas encore

    public Agent createAgent(Agent agent) {
        if (agent.getRegion() != null && agent.getRegion().getId() != null) {
            Region region = regionRepository.findById(agent.getRegion().getId())
                    .orElseThrow(() -> new RuntimeException("Region not found"));
            agent.setRegion(region); // lie la region "managed"
        } else {
            agent.setRegion(null);
        }
        return agentRepository.save(agent);
    }


    public Agent updateAgent(Long id, Agent updatedAgent) {
        return agentRepository.findById(id).map(agent -> {
            agent.setNom(updatedAgent.getNom());
            agent.setRegion(updatedAgent.getRegion());
            return agentRepository.save(agent);
        }).orElse(null);
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
    public List<Agent> getAgentsByRegionNom(String regionNom) {
        return agentRepository.findByRegionNom(regionNom);
    }
}
