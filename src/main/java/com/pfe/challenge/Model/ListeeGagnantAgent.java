package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ListeeGagnantAgent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomAgent;
    private Double score;
    private Double montant;

    private int rang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonIgnore
    private Challenge challenge;


    public ListeeGagnantAgent() {

    }

    public ListeeGagnantAgent(Long id, String nomAgent, Double score, Double montant, int rang, Challenge challenge) {
        this.id = id;
        this.nomAgent = nomAgent;
        this.score = score;
        this.montant = montant;
        this.rang = rang;
        this.challenge = challenge;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
