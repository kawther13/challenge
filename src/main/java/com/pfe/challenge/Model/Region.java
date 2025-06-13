package com.pfe.challenge.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Region {
    @Id @GeneratedValue
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    private List<Agence> agences;
    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    private List<Agent> agents;

    public Region() {}

    public Region(Long id, String nom, List<Agence> agences, List<Agent> agents) {
        this.id = id;
        this.nom = nom;
        this.agences = agences;
        this.agents = agents;
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

    public List<Agence> getAgences() {
        return agences;
    }

    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
}
