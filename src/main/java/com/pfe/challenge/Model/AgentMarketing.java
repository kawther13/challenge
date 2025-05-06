package com.pfe.challenge.Model;


import jakarta.persistence.*;


import java.util.List;

@Entity
public class AgentMarketing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<Defi> defis;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Defi> getDéfis() { return defis; }
    public void setDéfis(List<Defi> défis) { this.defis = défis; }
}
