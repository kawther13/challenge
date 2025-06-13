package com.pfe.challenge.scheduled;

import com.pfe.challenge.Service.GagnantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private GagnantService gainService;

    // Suppose qu'on a une liste de challenges [1,2,3,...]
    private List<Long> challengeIds = List.of(1L, 2L); // Peut être dynamique

    // Chaque jour à 00h05
    @Scheduled(cron = "0 5 0 * * *")
    public void processGainsDaily() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        for (Long challengeId : challengeIds) {
            gainService.traiterGagnantsParChallenge(challengeId);
        }
    }
}