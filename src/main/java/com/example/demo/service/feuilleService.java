package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Etudiant;
import com.example.demo.model.Feuille;

public interface feuilleService {

    public void ajouterFeuille(String mois, Etudiant etudiant);

    public List<Feuille> getAllFeuilles(Etudiant etudiant);

}
