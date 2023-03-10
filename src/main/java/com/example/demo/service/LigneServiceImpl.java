package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ligne;
import com.example.demo.repository.EtudiantRepo;
import com.example.demo.repository.LigneRepo;

@Service
public class LigneServiceImpl implements LigneService {

    @Autowired
    private LigneRepo LR;

    @Override
    public void delete(Long id) {
        LR.deleteById(id);
    }

}