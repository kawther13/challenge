package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Commercant {
    @Id @GeneratedValue
    private Long id;
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    @JsonIgnore
    private Agence agence;

    @OneToMany(mappedBy = "commercant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Participant> participations;

    public Commercant() {

    }
/*****/
    public Commercant(Long id, String nom, Agence agence, List<Participant> participations) {
        this.id = id;
        this.nom = nom;
        this.agence = agence;
        this.participations = participations;
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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Participant> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participant> participations) {
        this.participations = participations;
    }

}
