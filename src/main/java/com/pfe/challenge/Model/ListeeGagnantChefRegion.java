package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class ListeGagnantChefRegion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private Double score;
    private Double montant;
    private int rang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonIgnore
    private Challenge challenge;


    public ListeGagnantChefRegion() {}

    public ListeGagnantChefRegion(Long id, String nom, Double score, Double montant, int rang, Challenge challenge) {
        this.id = id;
        this.nom = nom;
        this.score = score;
        this.montant = montant;
        this.rang = rang;
        this.challenge = challenge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}

