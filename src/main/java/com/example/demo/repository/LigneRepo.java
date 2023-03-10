package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.ligne;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LigneRepo extends JpaRepository<ligne, Long> {

    public List<ligne> findAll();

    void deleteById(Long id);

}
