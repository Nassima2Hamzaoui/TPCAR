package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Feuille;
import com.example.demo.repository.FeuilleRepo;

@Service
public class feuilleServiceImpl implements feuilleService {

    @Autowired
    private FeuilleRepo feuilleRepo;

    @Override
    public Feuille ajouterFeuille(Feuille feuille) {
        return feuilleRepo.save(feuille);
    }

    @Override
    public List<Feuille> getAllFeuilles() {
        return feuilleRepo.findAll();
    }

    @Override
    public Feuille getFeuilleDePresence(String mois) {
        List<Feuille> feuilles = feuilleRepo.findByMois(mois);
        if (feuilles.isEmpty()) {
            return null;
        } else {
            return feuilles.get(0);
        }
    }
}
