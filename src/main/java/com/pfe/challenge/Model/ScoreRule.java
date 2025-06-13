package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ScoreRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ScoreType scoreType; // CONTRACT, PACK, REVENUE

    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    private PackType packType;

    private Double revenueUnit; // unité de revenu pour le score REVENUE
    private int points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonBackReference
    private Challenge challenge;

    public ScoreRule() {

    }

    public ScoreRule(Long id, ScoreType scoreType, ContractType contractType, PackType packType, Double revenueUnit, int points, Challenge challenge) {
        this.id = id;
        this.scoreType = scoreType;
        this.contractType = contractType;
        this.packType = packType;
        this.revenueUnit = revenueUnit;
        this.points = points;
        this.challenge = challenge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public PackType getPackType() {
        return packType;
    }

    public void setPackType(PackType packType) {
        this.packType = packType;
    }

    public Double getRevenueUnit() {
        return revenueUnit;
    }

    public void setRevenueUnit(Double revenueUnit) {
        this.revenueUnit = revenueUnit;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
