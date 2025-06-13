package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @JsonIgnore
    private Region region;
    @OneToMany(mappedBy = "agent")
    private List<Participant> participations;

    public Agent() {}

    public Agent(Long id, String nom, Region region, List<Participant> participations) {
        this.id = id;
        this.nom = nom;
        this.region = region;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Participant> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participant> participations) {
        this.participations = participations;
    }
}

