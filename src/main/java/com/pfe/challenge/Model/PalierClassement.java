package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class PalierClassement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nbr;
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RolePalier_id", referencedColumnName = "id")
    @JsonIgnore
    private RolePaliers rolePaliers;



    public PalierClassement() {}

    public PalierClassement(Long id, Integer nbr, Double montant, RolePaliers rolePaliers) {
        this.id = id;
        this.nbr = nbr;
        this.montant = montant;
        this.rolePaliers = rolePaliers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbr() {
        return nbr;
    }

    public void setNbr(Integer nbr) {
        this.nbr = nbr;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public RolePaliers getRolePaliers() {
        return rolePaliers;
    }

    public void setRolePaliers(RolePaliers rolePaliers) {
        this.rolePaliers = rolePaliers;
    }
}
