package com.pfe.challenge.Service;

import com.pfe.challenge.Model.*;
import com.pfe.challenge.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GagnantService {
    @Autowired
    private SalesTransactionRepository transactionRepo;
    @Autowired
    private ConditionGainRepository conditionRepo;
    @Autowired
    private ListeGagnantAgentRepository agentRepo;
    @Autowired
    private ListeGagnantCommercialRepository commercialRepo;
    @Autowired
    private ListeGagnantChefAgenceRepository chefAgenceRepo;
    @Autowired
    private ListeGagnantChefRegionRepository chefRegionRepo;
    @Transactional
    public void traiterGagnantsParChallenge(Long challengeId) {

        // Supprimer les anciens gagnants de ce challenge pour cette date
        agentRepo.deleteByChallengeId(challengeId);
        commercialRepo.deleteByChallengeId(challengeId);
        chefAgenceRepo.deleteByChallengeId(challengeId);
        chefRegionRepo.deleteByChallengeId(challengeId);

        // Récupérer transactions et conditions du challenge pour cette date
        List<SalesTransaction> transactions = transactionRepo.findByChallengeId(challengeId);
        List<ConditionGain> conditions = conditionRepo.findByChallengeId(challengeId);

        List<SalesTransaction> agentTransactions = new ArrayList<>();
        List<SalesTransaction> commercialTransactions = new ArrayList<>();
        Map<String, List<SalesTransaction>> transactionsParAgence = new HashMap<>();
        Map<String, List<SalesTransaction>> transactionsParRegion = new HashMap<>();

        // Répartition des transactions par rôle
        for (SalesTransaction t : transactions) {
            String role = t.getSellerRole();
            if ("agent".equalsIgnoreCase(role)) {
                agentTransactions.add(t);
                transactionsParRegion.computeIfAbsent(t.getNomRegion(), k -> new ArrayList<>()).add(t);
            } else if ("commercant".equalsIgnoreCase(role)) {
                commercialTransactions.add(t);
                transactionsParAgence.computeIfAbsent(t.getNomAgence(), k -> new ArrayList<>()).add(t);
                transactionsParRegion.computeIfAbsent(t.getNomRegion(), k -> new ArrayList<>()).add(t);
            }
        }

        // Évaluation des conditions pour chaque rôle
        for (ConditionGain c : conditions) {
            switch (c.getRole().toLowerCase()) {
                case "agent":
                    for (SalesTransaction t : agentTransactions)
                        if (verifieCondition(t, c)) {

                            agentRepo.save(new ListeGagnantAgent(
                                    null,
                                    t.getNom(),
                                    t.getProduct().name(),

                                    t.getContractType().name(),
                                    t.getTransactionNature().name(),
                                    t.getNbrContrat(),
                                    t.getPrime(),
                                    t.getNomAgence(),
                                    t.getNomRegion(),
                                    t.getDateTransaction(),
                                    t.getPacktype(),

                                    challengeId
                            ));

                        }
                    break;


                case "commercant":
                    for (SalesTransaction t : commercialTransactions)
                        if (verifieCondition(t, c)) {
                            commercialRepo.save(new ListeGagnantCommercial(null,
                                    t.getNom(),
                                    t.getProduct().name(),
                                    t.getContractType().name(),
                                    t.getTransactionNature().name(),
                                    t.getNbrContrat(),
                                    t.getPrime(),
                                    t.getNomAgence(),
                                    t.getNomRegion(),
                                    t.getDateTransaction(),
                                    challengeId));
                        }
                    break;

                case "chef_agence":
                    for (Map.Entry<String, List<SalesTransaction>> entry : transactionsParAgence.entrySet()) {
                        String nomAgence = entry.getKey();
                        List<SalesTransaction> transCommercants = entry.getValue();

                        int totalContrats = transCommercants.stream().mapToInt(SalesTransaction::getNbrContrat).sum();
                        double totalPrimes = transCommercants.stream().mapToDouble(SalesTransaction::getPrime).sum();

                        if (verifieCondition(totalContrats, totalPrimes, c)) {
                            chefAgenceRepo.save(new ListeGagnantChefAgence());
                        }
                    }
                    break;

                case "chef_region":
                    for (Map.Entry<String, List<SalesTransaction>> entry : transactionsParRegion.entrySet()) {
                        String nomRegion = entry.getKey();
                        List<SalesTransaction> transRegion = entry.getValue();

                        int contrats = transRegion.stream().mapToInt(SalesTransaction::getNbrContrat).sum();
                        double primes = transRegion.stream().mapToDouble(SalesTransaction::getPrime).sum();

                        if (verifieCondition(contrats, primes, c)) {

                            chefRegionRepo.save(new ListeGagnantChefRegion());
                        }
                    }
                    break;
            }
        }
    }

    // Vérifie condition pour agent / commerçant
    private boolean verifieCondition(SalesTransaction t, ConditionGain c) {
        return (c.getNbrContrat() == null || t.getNbrContrat() >= c.getNbrContrat()) &&
                (c.getPrime() == null || t.getPrime() >= c.getPrime()) &&
                (c.getTypeContrat() == null || c.getTypeContrat().equalsIgnoreCase(t.getContractType().name()));
    }

    // Vérifie condition pour chef d’agence / chef de région
    private boolean verifieCondition(int totalContrats, double totalPrimes, ConditionGain c) {
        return (c.getNbrContrat() == null || totalContrats >= c.getNbrContrat()) &&
                (c.getPrime() == null || totalPrimes >= c.getPrime());
    }

}