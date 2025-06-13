package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
public class PalierIntervalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer min;
    private Integer max;
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RolePalier_id", referencedColumnName = "id")
    @JsonIgnore
    private RolePaliers rolePaliers;

    public PalierIntervalle() {}

    public PalierIntervalle(Long id, Integer min, Integer max, Double montant, RolePaliers rolePaliers) {
        this.id = id;
        this.min = min;
        this.max = max;
        this.montant = montant;
        this.rolePaliers = rolePaliers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
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
