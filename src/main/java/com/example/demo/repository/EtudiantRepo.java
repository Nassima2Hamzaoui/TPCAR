package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, String> {

    Etudiant findByMail(String mail);

}
