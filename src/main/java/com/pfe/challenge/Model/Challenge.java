package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @ElementCollection
    private List<String> participantsConcernes;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rule> rules;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ScoreRule> scoreRules;

  /*  @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<ConditionGainAgent> conditionsGainAgent;*/




    @ElementCollection(targetClass = TypeParticipant.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "challenge_concerners", joinColumns = @JoinColumn(name = "challenge_id"))
    @Column(name = "type_participant")
    private List<TypeParticipant> concerner;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RolePaliers> rolePaliers;


// deja
    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SalesTransaction> sales = new ArrayList<>();

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Participant> participants;
//deja
    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ConditionGain> conditionGains;
    // Getters & Setters
/**********************************************************************/
    /**@OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<ChefAgence> chefAgences;

     @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
     private List<ChefRegion> chefregion;
     ****************************************************************************/
    public Challenge() {
    }

    public Challenge(Long id, String nom, String description, LocalDate dateDebut, LocalDate dateFin, List<String> participantsConcernes, List<Rule> rules, List<ScoreRule> scoreRules, List<TypeParticipant> concerner, List<RolePaliers> rolePaliers, List<SalesTransaction> sales, List<Participant> participants, List<ConditionGain> conditionGains) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.participantsConcernes = participantsConcernes;
        this.rules = rules;
        this.scoreRules = scoreRules;
      //  this.conditionsGainAgent = conditionsGainAgent;
        this.concerner = concerner;
        this.rolePaliers = rolePaliers;
        this.sales = sales;
        this.participants = participants;
        this.conditionGains = conditionGains;
    }

    public List<ScoreRule> getScoreRules() {
        return scoreRules;
    }

    public void setScoreRules(List<ScoreRule> scoreRules) {
        this.scoreRules = scoreRules;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public List<String> getParticipantsConcernes() {
        return participantsConcernes;
    }

    public void setParticipantsConcernes(List<String> participantsConcernes) {
        this.participantsConcernes = participantsConcernes;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

  /*  public List<ConditionGainAgent> getConditionsGainAgent() {
        return conditionsGainAgent;
    }*/

   /* public void setConditionsGainAgent(List<ConditionGainAgent> conditionsGainAgent) {
        this.conditionsGainAgent = conditionsGainAgent;
    }
*/

    public List<TypeParticipant> getConcerner() {
        return concerner;
    }

    public void setConcerner(List<TypeParticipant> concerner) {
        this.concerner = concerner;
    }

    public List<RolePaliers> getRolePaliers() {
        return rolePaliers;
    }

    public void setRolePaliers(List<RolePaliers> rolePaliers) {
        this.rolePaliers = rolePaliers;
    }

    public List<SalesTransaction> getSales() {
        return sales;
    }

    public void setSales(List<SalesTransaction> sales) {
        this.sales = sales;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<ConditionGain> getConditionGains() {
        return conditionGains;
    }

    public void setConditionGains(List<ConditionGain> conditionGains) {
        this.conditionGains = conditionGains;
    }
}