package com.pfe.challenge.Controller;

import com.pfe.challenge.Model.ConditionGainAgent;
import com.pfe.challenge.Model.Rule;
import com.pfe.challenge.Service.ConditionGainAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value ="/condition_agent")
public class ConditionGainAgentController {
    @Autowired
    ConditionGainAgentService conditionGainAgentService;
    @PostMapping("/save/{challenge_id}")
    public ResponseEntity<ConditionGainAgent> createRule(@PathVariable long challenge_id, @RequestBody ConditionGainAgent conditionGainAgent) {
        ConditionGainAgent  createdCondition  = conditionGainAgentService.creatercondition(challenge_id, conditionGainAgent);
        return ResponseEntity.ok(createdCondition);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConditionGainAgent> updateRule(@PathVariable Long id, @RequestBody ConditionGainAgent conditionGainAgent) {
        ConditionGainAgent updated = conditionGainAgentService.updateCondition_agent(id,conditionGainAgent);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {
        conditionGainAgentService.deleteCondition(id);
        return ResponseEntity.ok("condition supprimée avec succès.");
    }
}
