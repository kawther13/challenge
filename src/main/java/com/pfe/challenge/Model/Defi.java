package com.pfe.challenge.Model;

import com.pfe.challenge.Model.enums.ConditionGain;
import com.pfe.challenge.Model.enums.TypeContrat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Defi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_defi;


    private LocalDate date_debut;
    private LocalDate date_fin;
    private String concernes;
    private int nombre_contrat_min;
    private String produitsConcernés;

    @Embedded
    private ConditionGain conditionGain;
    @Enumerated(EnumType.STRING)
    private TypeContrat type_contrat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private AgentMarketing agent;

    // ======== Getters ========

    public int getId_defi() {
        return id_defi;
    }


    public LocalDate getDate_debut() {
        return date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public String getConcernes() {
        return concernes;
    }

    public int getNombre_contrat_min() {
        return nombre_contrat_min;
    }

    public TypeContrat getType_contrat() {
        return type_contrat;
    }

    // ======== Setters ========

    public void setId_defi(int id_defi) {
        this.id_defi = id_defi;
    }



    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public void setConcernes(String concernes) {
        this.concernes = concernes;
    }

    public void setNombre_contrat_min(int nombre_contrat_min) {
        this.nombre_contrat_min = nombre_contrat_min;
    }

    public void setType_contrat(TypeContrat type_contrat) {
        this.type_contrat = type_contrat;
    }

    public String getProduitsConcernés() {
        return produitsConcernés;
    }

    public AgentMarketing getAgent() {
        return agent;
    }

    public ConditionGain getConditionGain() {
        return conditionGain;
    }

    public void setProduitsConcernés(String produitsConcernés) {
        this.produitsConcernés = produitsConcernés;
    }

    public void setAgent(AgentMarketing agent) { this.agent = agent; }
    public void setConditionGain(ConditionGain conditionGain) { this.conditionGain = conditionGain; }
}

