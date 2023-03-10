
package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Feuille {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mail")
    private Etudiant etudiant;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feuilleDePresence")
    private List<ligne> lignes = new ArrayList<>();

    private String mois;

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Feuille() {

    }

    public List<ligne> getLignes() {
        return lignes;
    }

    public void setLignes(List<ligne> lignes) {
        this.lignes = lignes;
    }

    public Feuille(Long id, Etudiant etudiant, List<ligne> lignes, String mois) {
        this.id = id;
        this.etudiant = etudiant;
        this.lignes = lignes;
        this.mois = mois;
    }

}