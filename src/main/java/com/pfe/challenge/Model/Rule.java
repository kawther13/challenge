package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractType; // e.g., NOUVEAU, RENOUVELLEMENT
    private String transactionNature; // e.g., ENCAISSEMENT
    private String packType;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonBackReference
    private Challenge challenge;
    public Long getChallengeId() {
        return (challenge != null) ? challenge.getId() : null;
    }


    public Rule() {}

    public Rule(Long id, String contractType, String transactionNature, String packType, Challenge challenge) {
        this.id = id;
        this.contractType = contractType;
        this.transactionNature = transactionNature;
        this.packType = packType;
        this.challenge = challenge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
