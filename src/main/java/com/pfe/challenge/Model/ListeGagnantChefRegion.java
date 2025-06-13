package com.pfe.challenge.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ListeGagnantChefRegion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomRegion;
    private int totalContrats;
    private double totalPrime;
    private LocalDate dateTransaction;
    private Long challengeId;
    // Getters & Setters

    public ListeGagnantChefRegion() {

    }

    public ListeGagnantChefRegion(Long id, String nomRegion, int totalContrats, double totalPrime, LocalDate dateTransaction, Long challengeId) {
        this.id = id;
        this.nomRegion = nomRegion;
        this.totalContrats = totalContrats;
        this.totalPrime = totalPrime;
        this.dateTransaction = dateTransaction;
        this.challengeId = challengeId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getTotalContrats() {
        return totalContrats;
    }

    public void setTotalContrats(int totalContrats) {
        this.totalContrats = totalContrats;
    }

    public double getTotalPrime() {
        return totalPrime;
    }

    public void setTotalPrime(double totalPrime) {
        this.totalPrime = totalPrime;
    }





    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }
}