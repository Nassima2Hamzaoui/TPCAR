package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Etudiant;
import com.example.demo.model.Feuille;

public interface EtudiantService {

    Etudiant ajouterEtudiant(Etudiant etudiant);

    Etudiant ConnectEtudiant(String mail, String mdp);

}
