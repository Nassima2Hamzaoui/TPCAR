package com.example.demo.service;

import com.example.demo.model.Etudiant;

public interface EtudiantService {

    Etudiant ajouterEtudiant(Etudiant etudiant);

    Etudiant ConnectEtudiant(String mail, String mdp);

}
