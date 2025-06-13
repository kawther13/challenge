package com.pfe.challenge.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ListeGagnantCommercial {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String product;
    private String contractType;
    private String transactionNature;
    private int nbrContrat;
    private double prime;
    private String nomAgence;
    private String nomRegion;
    private LocalDate dateTransaction;

    private Long challengeId;
    // Getters & Setters

    public ListeGagnantCommercial() {

    }

    public ListeGagnantCommercial(Long id, String nom, String product, String contractType, String transactionNature, int nbrContrat, double prime, String nomAgence, String nomRegion, LocalDate dateTransaction, Long challengeId) {
        this.id = id;
        this.nom = nom;
        this.product = product;
        this.contractType = contractType;
        this.transactionNature = transactionNature;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getTransactionNature() {
        return transactionNature;
    }

    public void setTransactionNature(String transactionNature) {
        this.transactionNature = transactionNature;
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
