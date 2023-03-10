package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ligne {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Feuille feuilleDePresence;

    private Date jour;
    private String matiere;
    private String debut;
    private String fin;
    private String enseignant;

    public ligne() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Feuille getFeuilleDePresence() {
        return feuilleDePresence;
    }

    public void setFeuilleDePresence(Feuille feuilleDePresence) {
        this.feuilleDePresence = feuilleDePresence;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public ligne(Long id, Feuille feuilleDePresence, Date jour, String matiere, String debut, String fin,
            String enseignant) {
        this.id = id;
        this.feuilleDePresence = feuilleDePresence;
        this.jour = jour;
        this.matiere = matiere;
        this.debut = debut;
        this.fin = fin;
        this.enseignant = enseignant;
    }

}
