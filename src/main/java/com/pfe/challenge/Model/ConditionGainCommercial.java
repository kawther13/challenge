package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ConditionGainCommercial {
    @Id @GeneratedValue
    private Long id;
    private double Nbr_contrat;
    private double prime_encaissé;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @JsonIgnore
    private Challenge challenge;
}
