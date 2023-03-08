package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Feuille;

public interface feuilleService {

    public Feuille ajouterFeuille(Feuille feuille);

    public List<Feuille> getAllFeuilles();

    public Feuille getFeuilleDePresence(String mois);

}
