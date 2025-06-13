package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class RolePaliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role; // "agent", "chef_agence", etc.
    private String typeGain; // "classement" ou "palier"
    @OneToMany(mappedBy = "rolePaliers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PalierIntervalle> palier;
    @OneToMany(mappedBy = "rolePaliers",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PalierClassement> classement ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonBackReference
    private Challenge challenge;

    public RolePaliers() {}

    public RolePaliers(Long id, String role, String typeGain, List<PalierIntervalle> palier, List<PalierClassement> classement, Challenge challenge) {
        this.id = id;
        this.role = role;
        this.typeGain = typeGain;
        this.palier = palier;
        this.classement = classement;
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

    public String getTypeGain() {
        return typeGain;
    }

    public void setTypeGain(String typeGain) {
        this.typeGain = typeGain;
    }

    public List<PalierIntervalle> getPalier() {
        return palier;
    }

    public void setPalier(List<PalierIntervalle> palier) {
        this.palier = palier;
    }

    public List<PalierClassement> getClassement() {
        return classement;
    }

    public void setClassement(List<PalierClassement> classement) {
        this.classement = classement;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
