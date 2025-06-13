package com.pfe.challenge.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Commercial {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;

    @ManyToOne
    private Agence agence;
}
