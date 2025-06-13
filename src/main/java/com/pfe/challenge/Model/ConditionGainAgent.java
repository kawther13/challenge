package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ConditionGainAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double Nbr_contrat;
    private double prime_encaissé;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonIgnore
    private Challenge challenge;

    public Long getChallengeId() {
        return (challenge != null) ? challenge.getId() : null;
    }

    public ConditionGainAgent() {

    }

    /************************/

    public ConditionGainAgent(Long id, double nbr_contrat, double prime_encaissé, Challenge challenge) {
        this.id = id;
        Nbr_contrat = nbr_contrat;
        this.prime_encaissé = prime_encaissé;
        this.challenge = challenge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNbr_contrat() {
        return Nbr_contrat;
    }

    public void setNbr_contrat(double nbr_contrat) {
        Nbr_contrat = nbr_contrat;
    }

    public double getPrime_encaissé() {
        return prime_encaissé;
    }

    public void setPrime_encaissé(double prime_encaissé) {
        this.prime_encaissé = prime_encaissé;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
