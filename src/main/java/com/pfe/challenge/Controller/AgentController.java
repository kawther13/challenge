package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.Agent;
import com.pfe.challenge.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")

public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Long id) {
        return agentService.getAgentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent updatedAgent) {
        Agent agent = agentService.updateAgent(id, updatedAgent);
        if (agent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/by-region/{regionNom}")//
    public List<Agent> getAgentsByRegionNom(@PathVariable String regionNom) {
        return agentService.getAgentsByRegionNom(regionNom);
    }
// @GetMapping("/by-region") -> @RequestParam String regionNom--->http://localhost:8080/api/agents/by-region?regionNom=Nord
}
