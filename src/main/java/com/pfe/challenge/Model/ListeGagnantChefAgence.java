package com.pfe.challenge.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ListeGagnantChefAgence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int nbrContrat;
    private double prime;
    private String nomAgence;
    private String nomRegion;
    private LocalDate dateTransaction;

    private Long challengeId;

    // Getters & Setters

    public ListeGagnantChefAgence() {

    }

    public ListeGagnantChefAgence(Long id, int nbrContrat, double prime, String nomAgence, String nomRegion, LocalDate dateTransaction, Long challengeId) {
        this.id = id;
        this.nbrContrat = nbrContrat;
        this.prime = prime;
        this.nomAgence = nomAgence;
        this.nomRegion = nomRegion;
        this.dateTransaction = dateTransaction;
        this.challengeId = challengeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrContrat() {
        return nbrContrat;
    }

    public void setNbrContrat(int nbrContrat) {
        this.nbrContrat = nbrContrat;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }
}
