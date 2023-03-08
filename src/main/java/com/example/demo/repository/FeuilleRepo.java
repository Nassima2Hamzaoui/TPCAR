package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Feuille;

@Repository
public interface FeuilleRepo extends JpaRepository<Feuille, String> {

    List<Feuille> findByMois(String mois);
}
