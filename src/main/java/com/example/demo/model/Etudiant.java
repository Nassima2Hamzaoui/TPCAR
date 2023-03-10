package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Etudiant {

    @Id
    private String mail;
    private String mdp;

    private String nom;
    private String prenom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private List<Feuille> feuillesDePresence = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Etudiant() {
    }

    public List<Feuille> getFeuillesDePresence() {
        return feuillesDePresence;
    }

    public void setFeuillesDePresence(List<Feuille> feuillesDePresence) {
        this.feuillesDePresence = feuillesDePresence;
    }

    public Etudiant(String mail, String mdp, String nom, String prenom, List<Feuille> feuillesDePresence) {
        this.mail = mail;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.feuillesDePresence = feuillesDePresence;
    }

}
