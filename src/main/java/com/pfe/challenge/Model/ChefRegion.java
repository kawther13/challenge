package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
public class ChefRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private int nombreContrats;
    private Double score;
    private double primeEncaissee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonIgnore
    private Challenge challenge;

    public ChefRegion() {}

    public ChefRegion(Long id, String nom, int nombreContrats, Double score, double primeEncaissee, Challenge challenge) {
        this.id = id;
        this.nom = nom;
        this.nombreContrats = nombreContrats;
        this.score = score;
        this.primeEncaissee = primeEncaissee;
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

    public int getNombreContrats() {
        return nombreContrats;
    }

    public void setNombreContrats(int nombreContrats) {
        this.nombreContrats = nombreContrats;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public double getPrimeEncaissee() {
        return primeEncaissee;
    }

    public void setPrimeEncaissee(double primeEncaissee) {
        this.primeEncaissee = primeEncaissee;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}