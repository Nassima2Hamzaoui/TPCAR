package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Etudiant;
import com.example.demo.model.Feuille;
import com.example.demo.repository.FeuilleRepo;
import com.example.demo.service.EtudiantService;
import com.example.demo.service.feuilleService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/etudiant")
public class FeuilleController {

    @Autowired
    private feuilleService FS;

    @Autowired
    private FeuilleRepo FR;

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/add")
    public String getFeuilleDePresence(@RequestParam("mois") String mois, Model model) {
        // Vérifier que le mois est bien renseigné
        if (mois == null || mois.isEmpty()) {
            return "etudiant";
        }

        // Récupérer la feuille de présence du mois correspondant
        Feuille feuille = FS.getFeuilleDePresence(mois);

        // Ajouter la feuille de présence au modèle pour l'afficher dans la vue
        model.addAttribute("feuille", feuille);

        return "etudiant";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Supprimer la session de l'utilisateur
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Rediriger vers la page de connexion
        return "authentif";
    }

}