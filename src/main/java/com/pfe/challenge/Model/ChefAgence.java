package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
public class ChefAgence {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private Double score;
    private double nombreContrats;

    private double primeEncaissee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonIgnore
    private Challenge challenge;

    public ChefAgence() {}

    public ChefAgence(Long id, String nom, double nombreContrats, double primeEncaissee, Challenge challenge) {
        this.id = id;
        this.nom = nom;
        this.nombreContrats = nombreContrats;
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

    public double getNombreContrats() {
        return nombreContrats;
    }

    public void setNombreContrats(double nombreContrats) {
        this.nombreContrats = nombreContrats;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
