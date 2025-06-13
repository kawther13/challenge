package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ConditionGain {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role; // agent, commercant, chef_agence, chef_region
    private Integer nbrContrat;
    private Double prime;
    private String typeContrat;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    @JsonBackReference
    private Challenge challenge;

    public ConditionGain() {

    }

    public ConditionGain(Long id, String role, Integer nbrContrat, Double prime, String typeContrat, Challenge challenge) {
        this.id = id;
        this.role = role;
        this.nbrContrat = nbrContrat;
        this.prime = prime;
        this.typeContrat = typeContrat;
        this.challenge = challenge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getNbrContrat() {
        return nbrContrat;
    }

    public void setNbrContrat(Integer nbrContrat) {
        this.nbrContrat = nbrContrat;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}