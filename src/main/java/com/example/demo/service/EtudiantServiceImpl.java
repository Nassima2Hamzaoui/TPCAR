package com.example.demo.service;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepo;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepo ER;

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        // TODO Auto-generated method stub
        return ER.save(etudiant);
    }

    public Etudiant ConnectEtudiant(String mail, String mdp) {
        Etudiant etudiant = ER.findByMail(mail);
        if (etudiant != null && etudiant.getMdp().equals(mdp)) {
            return etudiant;
        }
        return null;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return ER.findAll();
    }

}