package com.pfe.challenge.Service;

import com.pfe.challenge.Model.*;

import com.pfe.challenge.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChallengeService {
@Autowired
  private ChallengeRepository challengeRepository;
    @Autowired
    private CommercantRepository commercantRepository;
    @Autowired
    private ParticipantRepository participantRepository;
@Autowired
private  ChefAgenceRepository chefAgenceRepository;
    @Autowired private AgentRepository agentRepository;
    @Autowired private ClassementAgentRepository classementAgentRepository;
    public Challenge createChallenge(Challenge challenge) {

        Challenge saved = challengeRepository.save(challenge);

        for (TypeParticipant type : challenge.getConcerner()) {
            switch (type) {
                case COMMERCANT:
                    List<Commercant> commercants = commercantRepository.findAll();
                    commercants.forEach(c -> {
                        Participant p = new Participant();
                        p.setChallenge(saved);
                        p.setCommercant(c);
                        participantRepository.save(p);
                    });
                    break;

                case AGENT:
                    List<Agent> agents = agentRepository.findAll();
                    agents.forEach(a -> {
                        Participant p = new Participant();
                        p.setChallenge(saved);
                        p.setAgent(a);
                        participantRepository.save(p);
                    });
                    break;

                case CHEF_AGENCE:
                   /** List<ChefAgence> chefsAgence = chefAgenceRepository.findAll();
                    chefsAgence.forEach(ca -> {
                        Participant p = new Participant();
                        p.setChallenge(saved);
                        p.setChefAgence(ca);
                        participantRepository.save(p);
                    });*/
                    break;

                case CHEF_REGION:
                   /* List<ChefRegion> chefsRegion = chefRegionRepository.findAll();
                    chefsRegion.forEach(cr -> {
                        Participant p = new Participant();
                        p.setChallenge(saved);
                        p.setChefRegion(cr);
                        participantRepository.save(p);
                    });*/
                    break;
            }
        }


        return saved;
    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public Optional<Challenge> getChallengeWithRuless(String id) {
        Optional<Challenge> challenge = challengeRepository.findByIdWithRules(id);
        challenge.ifPresent(c -> {
            System.out.println("Challenge retrieved: " + c);
            System.out.println("Rules: " + c.getRules());
        });
        return challenge;
    }

    public Optional<Challenge> getallcchallenge(Long id) {

        Optional<Challenge> challenge = challengeRepository.findById(id);
    return challenge;
    }

    public void deletechallenge(Long Id) {
        challengeRepository.deleteById(Id);
    }


    public Challenge updatechalle(Long Id, Challenge updatedchallenge) {
        Challenge existingchallenge = challengeRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));

        existingchallenge.setNom(updatedchallenge.getNom());
        existingchallenge.setDescription(updatedchallenge.getDescription());
        existingchallenge.setDateDebut(updatedchallenge.getDateDebut());
        existingchallenge.setDateFin(updatedchallenge.getDateFin());
        return challengeRepository.save(existingchallenge);
    }
/******* get les participant****/

public List<Commercant> getCommercantsByChallenge(Long challengeId) {
    return participantRepository.findByChallengeId(challengeId)
            .stream()
            .map(Participant::getCommercant)
            .collect(Collectors.toList());
}

    public List<Agence> getAgencesByChallenge(Long challengeId) {
        return getCommercantsByChallenge(challengeId)
                .stream()
                .map(Commercant::getAgence)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Region> getRegionsByChallenge(Long challengeId) {
        return getAgencesByChallenge(challengeId)
                .stream()
                .map(Agence::getRegion)
                .distinct()
                .collect(Collectors.toList());
    }
    public List<Agent> getAgentsByChallenge(Long challengeId) {
        return participantRepository.findByChallengeId(challengeId).stream()
                .map(Participant::getAgent)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    /***********************/



   /** public void traiterGainsPourChallenge(Long challengeId) {
        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge non trouvé"));

        List<GainHorsPalier> gains = challenge.getGainHorspalier();
        List<GainPalier> gainPaliers = challenge.getGainsParPalier();

        if (gains != null && !gains.isEmpty()) {
            attribuerGainsClassiques(challenge, gains);
        } else if (gainPaliers != null && !gainPaliers.isEmpty()) {
            attribuerGainsParPalier(challenge, gainPaliers);
        } else {
            throw new RuntimeException("Aucun gain défini pour ce challenge");
        }
    }

    private void attribuerGainsClassiques(Challenge challenge, List<GainHorsPalier> gains) {
        List<Agent> agents = agentRepository.findByChallengeId(challenge.getId());
         classementAgentRepository.deleteAll();
        agents.sort((a1, a2) -> Double.compare(
                a2.getNombreContrats() * 5 + a2.getPrimeEncaissee(),
                a1.getNombreContrats() * 5 + a1.getPrimeEncaissee()));

        int index = 0;
        int rang = 1;

        for (GainHorsPalier gain : gains) {
            for (int i = 0; i < gain.getNbGagnants() && index < agents.size(); i++) {
                Agent agent = agents.get(index++);
                double score = agent.getNombreContrats() * 5 + agent.getPrimeEncaissee();

                ClassementAgent classement = new ClassementAgent();
                classement.setNomAgent(agent.getNom());
                classement.setScore(score);
                classement.setRang(rang++);
                classement.setGain(gain.getMontant());
                classement.setChallenge(challenge);

                classementAgentRepository.save(classement);
            }
        }
    }

    private void attribuerGainsParPalier(Challenge challenge, List<GainPalier> paliers) {
        List<Agent> agents = agentRepository.findByChallengeId(challenge.getId());
        classementAgentRepository.deleteAll();
        agents.sort((a1, a2) -> Double.compare(
                a2.getNombreContrats() * 5 + a2.getPrimeEncaissee(),
                a1.getNombreContrats() * 5 + a1.getPrimeEncaissee()));

        int rang = 1;

        for (Agent agent : agents) {
            double score = agent.getNombreContrats() * 5 + agent.getPrimeEncaissee();
            double montantAttribue = 0;

            for (GainPalier palier : paliers) {
                if (score >= palier.getMin() &&  score<= palier.getMax()) {
                    montantAttribue = palier.getMontant();
                    break;
                }
            }



            ClassementAgent classement = new ClassementAgent();
            classement.setNomAgent(agent.getNom());
            classement.setScore(score);
            classement.setRang(rang++);
            classement.setGain(montantAttribue);
            classement.setChallenge(challenge);

            classementAgentRepository.save(classement);
        }
    }

    public List<ClassementAgent> getclassement() {

        List<ClassementAgent> agents = classementAgentRepository.findAll();
        return agents;
    }**/

}















