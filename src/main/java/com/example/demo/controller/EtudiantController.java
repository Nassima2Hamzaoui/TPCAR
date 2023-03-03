package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepo;
import com.example.demo.service.EtudiantService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantRepo ER;

    @Autowired
    private EtudiantService ES;

    @RequestMapping("/home")
    public String authentification(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "authentif";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("etudiant") Etudiant etudiant, Model model) {
        ES.ajouterEtudiant(etudiant);
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(Etudiant etudiant, Model model, HttpSession session) {
        Etudiant etudiantconnect = ES.ConnectEtudiant(etudiant.getMail(), etudiant.getMdp());
        if (etudiantconnect == null) {
            model.addAttribute("login erreur", "password ou mail est incorrect ");
            return "authentif";
        } else {
            session.setAttribute("etudiantconnect", etudiantconnect);
            return "/etudiant";
        }
    }

    @RequestMapping("/etudiant")
    public String etudiant(HttpSession session, Model model) {
        Etudiant etudiantconnect = (Etudiant) session.getAttribute("etudiantconnect");
        model.addAttribute("nom", etudiantconnect.getNom());
        model.addAttribute("prenom", etudiantconnect.getPrenom());
        return "etudiant";

    }
}
