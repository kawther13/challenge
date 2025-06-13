package com.pfe.challenge.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class SalesTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String sellerRole; // agent, commercant, chef_agence

private  String  packtype;
    @Enumerated(EnumType.STRING) private Product product;
    @Enumerated(EnumType.STRING) private ContractType contractType;
    @Enumerated(EnumType.STRING) private TransactionNature transactionNature;
    private int nbrContrat;
    private double prime;
    private String nomAgence;
    private String nomRegion;
    private LocalDate dateTransaction;






    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    @JsonBackReference
    private Challenge challenge;

    public SalesTransaction() {

    }


//constructeur


    public SalesTransaction(Long id, String nom, String sellerRole, Product product, ContractType contractType, TransactionNature transactionNature, int nbrContrat, double prime, String nomAgence, String nomRegion, LocalDate dateTransaction,String packtype, Challenge challenge) {
        this.id = id;
        this.nom = nom;
        this.sellerRole = sellerRole;
        this.product = product;
        this.contractType = contractType;
        this.transactionNature = transactionNature;
        this.nbrContrat = nbrContrat;
        this.prime = prime;
        this.nomAgence = nomAgence;
        this.nomRegion = nomRegion;
        this.dateTransaction = dateTransaction;
        this.challenge = challenge;
        this.packtype=packtype;
    }

    public String getPacktype() {
        return packtype;
    }

    public void setPacktype(String packtype) {
        this.packtype = packtype;
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

    public String getSellerRole() {
        return sellerRole;
    }

    public void setSellerRole(String sellerRole) {
        this.sellerRole = sellerRole;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public TransactionNature getTransactionNature() {
        return transactionNature;
    }

    public void setTransactionNature(TransactionNature transactionNature) {
        this.transactionNature = transactionNature;
    }

    public int getNbrContrat() {
        return nbrContrat;
    }

    public void setNbrContrat(int nbrContrat) {
        this.nbrContrat = nbrContrat;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}