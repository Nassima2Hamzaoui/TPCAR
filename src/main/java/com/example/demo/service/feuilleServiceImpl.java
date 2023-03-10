package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Etudiant;
import com.example.demo.model.Feuille;
import com.example.demo.repository.FeuilleRepo;

@Service
public class feuilleServiceImpl implements feuilleService {

    @Autowired
    private FeuilleRepo feuilleRepo;

    @Override
    public void ajouterFeuille(String mois, Etudiant etudiant) {
        Feuille feuille = new Feuille();
        feuille.setMois(mois);// définit le mois de la feuille
        feuille.setEtudiant(etudiant);
        feuilleRepo.save(feuille);

    }

    @Override
    public List<Feuille> getAllFeuilles(Etudiant etudiant) {
        return etudiant.getFeuillesDePresence();
    }

}
