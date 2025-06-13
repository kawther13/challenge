package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agence {
    @Id @GeneratedValue
    private Long id;
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @JsonIgnore
    private Region region;

    @OneToMany(mappedBy = "agence")
    private List<Commercant> commercants;

    public Agence() {

    }

    public Agence(Long id, String nom, Region region, List<Commercant> commercants) {
        this.id = id;
        this.nom = nom;
        this.region = region;
        this.commercants = commercants;
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

    public List<Commercant> getCommercants() {
        return commercants;
    }

    public void setCommercants(List<Commercant> commercants) {
        this.commercants = commercants;
    }
}
