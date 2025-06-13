package com.pfe.challenge.Service;

import com.pfe.challenge.Model.*;
import com.pfe.challenge.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GainService {

    @Autowired
    private AgentRepository agentRepo;
    @Autowired private ChefAgenceRepository chefAgenceRepo;
    @Autowired private ChefRegionRepository chefRegionRepo;

    @Autowired private ListeGagnantAgentRepository gagnantAgentRepo;
    @Autowired private ListeGagnantChefAgenceRepository gagnantChefAgenceRepo;
    @Autowired private ListeGagnantChefRegionRepository gagnantChefRegionRepo;

    @Autowired private ChallengeRepository challengeRepo;
    @Autowired private SalesTransactionRepository salesTransactionRepository;
@Autowired private RuleRepository RuleRepo;
    @Autowired private  ListeGagnantAgentRepository agentgagnant;
    /**repo score**/
    @Autowired private ScoreRuleRepository  scoreRuleRepo;
    /**  repository gain**/
    @Autowired private  GainAgentRepository gainAgentRepo;

    public void attribuerGains(Long challengeId) {
        Challenge challenge = challengeRepo.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge non trouvé avec ID: " + challengeId));

        List<RolePaliers> rolesPaliers = challenge.getRolePaliers();


        for (RolePaliers rp : rolesPaliers) {
            String role = rp.getRole();
            String type = rp.getTypeGain();

            switch (role.toLowerCase()) {
                case "agent":
                    if ("classement".equalsIgnoreCase(type)) {
                        attribuerGainsParClassementPourAgents(rp.getClassement(), challengeId);
                    } else {
                        attribuerGainsParPalierPourAgents(rp.getPalier(), challengeId);
                    }
                    break;
                case "chef_agence":
                    if ("classement".equalsIgnoreCase(type)) {
                        attribuerGainsParClassementPourChefAgence(rp.getClassement(), challengeId);
                    } else {
                        attribuerGainsParPalierPourChefAgence(rp.getPalier(), challengeId);
                    }
                    break;
                case "chef_region":
                    if ("classement".equalsIgnoreCase(type)) {
                        attribuerGainsParClassementPourChefRegion(rp.getClassement(), challengeId);
                    } else {
                        attribuerGainsParPalierPourChefRegion(rp.getPalier(), challengeId);
                    }
                    break;
                case "commercant":
                    if ("classement".equalsIgnoreCase(type)) {
                        attribuerGainsParClassementPourcommercant(rp.getClassement(), challengeId);
                    } else {
                        attribuerGainsParPalierPourcommercant(rp.getPalier(), challengeId);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Rôle inconnu : " + role);
            }
        }
    }

    // === AGENTS ===
    private void attribuerGainsParClassementPourAgents(List<PalierClassement> paliers, Long challengeId) {
       Optional<Challenge> challenge=challengeRepo.findById(challengeId);
        Challenge ch = challenge.get();
        gainAgentRepo.deleteAll();
        LocalDate date = LocalDate.now().minusDays(1);
        List <ListeGagnantAgent> agents =gagnantAgentRepo.findByChallengeId(challengeId);
        agents.sort((a1, a2) -> Double.compare(
                calculateScore(a1,ch),calculateScore(a2,ch)));

        int index = 0;
        int rang = 1;
        for (PalierClassement palier : paliers) {
            for (int i = 0; i < palier.getNbr() && index < agents.size(); i++) {
                ListeGagnantAgent agent = agents.get(index++);
                GainAgent gagnant = new  GainAgent();
                gagnant.setNomAgent(agent.getNom());
                gagnant.setMontant(palier.getMontant());
                gagnant.setRang(rang ++);
                gagnant.setScore(calculateScore(agent,ch));


                gainAgentRepo.save(gagnant);
            }
        }
    }

    private void attribuerGainsParPalierPourAgents(List<PalierIntervalle> paliers, Long challengeId) {
        Optional<Challenge> challenge=challengeRepo.findById(challengeId);
        Challenge ch = challenge.get();
        gainAgentRepo.deleteAll();
        LocalDate date = LocalDate.now().minusDays(1);
        List <ListeGagnantAgent> agents =gagnantAgentRepo.findByChallengeId(challengeId);
        agents.sort((a1, a2) -> Double.compare(
                calculateScore(a1,ch),calculateScore(a2,ch)));
        int rang = 1;
        for (ListeGagnantAgent agent : agents) {
                double  score=calculateScore(agent,ch);
            for (PalierIntervalle palier : paliers) {
                if (score >= palier.getMin() && score <= palier.getMax()) {
                    GainAgent gagnant = new  GainAgent();
                    gagnant.setNomAgent(agent.getNom());
                    gagnant.setMontant(palier.getMontant());
                    gagnant.setRang(rang ++);
                    gagnant.setScore(calculateScore(agent,ch));
                    gainAgentRepo.save(gagnant);

                    break;
                }
            }
        }
    }


    // === CHEF AGENCE ===
    private void attribuerGainsParClassementPourChefAgence(List<PalierClassement> paliers, Long challengeId) {
      /*  Optional<Challenge> challenge=challengeRepo.findById(challengeId);
        List<ChefAgence> chefs = challenge.get().getChefAgences();
        gagnantChefAgenceRepo.deleteAll();
        int index = 0;
        int rang = 1;
        chefs.sort((a1, a2) -> Double.compare(
                a2.getScore(),
                a1.getScore()));
        for (PalierClassement palier : paliers) {
            for (int i = 0; i < palier.getNbr() && index < chefs.size(); i++) {
                ChefAgence chef = chefs.get(index++);
                ListeeGagnantChefAgence gagnant = new ListeeGagnantChefAgence();
                gagnant.setNom(chef.getNom());
                gagnant.setScore(chef.getScore());
                gagnant.setMontant(palier.getMontant());
                gagnant.setRang(rang ++);


                gagnantChefAgenceRepo.save(gagnant);
            }
        }*/
    }

    private void attribuerGainsParPalierPourChefAgence(List<PalierIntervalle> paliers, Long challengeId) {
     /*   Optional<Challenge> challenge=challengeRepo.findById(challengeId);
        List<ChefAgence> chefs = challenge.get().getChefAgences();
        gagnantChefAgenceRepo.deleteAll();
        chefs.sort((a1, a2) -> Double.compare(
                a2.getScore(),
                a1.getScore()));
        int rang = 1;
        for (ChefAgence chef : chefs) {

            for (PalierIntervalle palier : paliers) {
                if (chef.getScore() >= palier.getMin() && chef.getScore() <= palier.getMax()) {
                    ListeeGagnantChefAgence gagnant = new ListeeGagnantChefAgence();
                    gagnant.setNom(chef.getNom());
                    gagnant.setScore(chef.getScore());
                    gagnant.setMontant(palier.getMontant());
                    gagnant.setRang(rang ++);

                    gagnantChefAgenceRepo.save(gagnant);
                    break;
                }
            }
        }*/
    }

    // === CHEF REGION ===
    private void attribuerGainsParClassementPourChefRegion(List<PalierClassement> paliers, Long challengeId) {
       /* Optional<Challenge> challenge=challengeRepo.findById(challengeId);
        List<ChefRegion> chefs = challenge.get().getChefregion();
        gagnantChefRegionRepo.deleteAll();
        chefs.sort((a1, a2) -> Double.compare(
                a2.getScore(),
                a1.getScore()));
        int index = 0;
        int rang = 1;
        for (PalierClassement palier : paliers) {
            for (int i = 0; i < palier.getNbr() && index < chefs.size(); i++) {
                ChefRegion chef = chefs.get(index++);
                ListeeGagnantChefRegion gagnant = new ListeeGagnantChefRegion();
                gagnant.setNom(chef.getNom());
                gagnant.setScore(chef.getScore());
                gagnant.setMontant(palier.getMontant());
                gagnant.setRang(rang ++);

                gagnantChefRegionRepo.save(gagnant);
            }
        }*/
    }

    private void attribuerGainsParPalierPourChefRegion(List<PalierIntervalle> paliers, Long challengeId) {
       /* Optional<Challenge> challenge =challengeRepo.findById(challengeId);
        List<ChefRegion> chefs = challenge.get().getChefregion();
        gagnantChefRegionRepo.deleteAll();
        chefs.sort((a1, a2) -> Double.compare(
                a2.getScore(),
                a1.getScore()));
        int rang = 1;
        for (ChefRegion chef : chefs) {

            for (PalierIntervalle palier : paliers) {
                if (chef.getScore() >= palier.getMin() && chef.getScore() <= palier.getMax()) {
                    ListeeGagnantChefRegion gagnant = new ListeeGagnantChefRegion();
                    gagnant.setNom(chef.getNom());
                    gagnant.setScore(chef.getScore());
                    gagnant.setMontant(palier.getMontant());
                    gagnant.setRang(rang ++);

                    gagnantChefRegionRepo.save(gagnant);
                    break;
                }
            }
        }*/
    }



    private void attribuerGainsParClassementPourcommercant(List<PalierClassement> paliers, Long challengeId) {

    }

    private void attribuerGainsParPalierPourcommercant(List<PalierIntervalle> paliers, Long challengeId) {}















    private double calculateScore(ListeGagnantAgent agent, Challenge challenge) {
        List<ScoreRule> scoreRules = scoreRuleRepo.findByChallengeId(challenge.getId());

        boolean matches = challenge.getRules().stream().anyMatch(r ->
                (r.getContractType() == null || r.getContractType().equals(agent.getContractType())) &&
                        (r.getTransactionNature()== null || r.getTransactionNature().equals(agent.getTransactionNature())) &&
                        (r.getPackType() == null || r.getPackType().equals(agent.getPackType()))
        );

        if (!matches) return 0;

        double score = 0;
        for (ScoreRule sr : scoreRules) {
            switch (sr.getScoreType()) {
                case CONTRACT:
                    if (sr.getContractType().name().equals(agent.getContractType())) {
                        score += sr.getPoints();
                    }
                    break;
                case PACK:
                    if (sr.getPackType().name().equals( agent.getPackType())) {
                        score += sr.getPoints();
                    }
                    break;
                case REVENUE:
                    if (sr.getRevenueUnit() != null && sr.getRevenueUnit() > 0) {
                        score += (agent.getPrime() / sr.getRevenueUnit()) * sr.getPoints();
                    }
                    break;
            }
        }

        return score;
    }


}
