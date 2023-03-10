package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Etudiant;
import com.example.demo.model.Feuille;
import com.example.demo.model.ligne;
import com.example.demo.repository.EtudiantRepo;
import com.example.demo.repository.FeuilleRepo;
import com.example.demo.service.EtudiantService;
import com.example.demo.service.LigneService;
import com.example.demo.service.feuilleService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantRepo ER;

    @Autowired
    private EtudiantService ES;
    private long id;

    @Autowired
    private feuilleService FS;

    @Autowired
    private FeuilleRepo FR;

    @Autowired
    private LigneService LS;

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
            return "redirect:/fp";
        }
    }

    @GetMapping("/fp")
    public String getAllFeuilles(Model model, HttpSession session) {
        if (session.getAttribute("etudiantconnect") == null) {
            return "redirect:/home";
        }
        // Récupérer toutes les feuilles de présence
        Etudiant etudiantconnect = (Etudiant) session.getAttribute("etudiantconnect");
        model.addAttribute("nom", etudiantconnect.getNom());
        model.addAttribute("prenom", etudiantconnect.getPrenom());
        etudiantconnect = ER.findByMail(etudiantconnect.getMail());
        List<Feuille> feuilles = FS.getAllFeuilles(etudiantconnect);

        // Ajouter les feuilles au modèle pour les afficher dans la vue
        model.addAttribute("feuilles", feuilles);

        return "etudiant";
    }

    @PostMapping("/add")
    public String ajouterFeuille(@RequestParam("mois") String mois, HttpSession session) {
        // Créer une nouvelle feuille de présence avec le mois donné
        // Feuille feuille = new Feuille();
        Etudiant etudiantconnect = (Etudiant) session.getAttribute("etudiantconnect");

        // Ajouter la feuille de présence à la base de données
        FS.ajouterFeuille(mois, etudiantconnect);

        // Rediriger vers la page qui affiche toutes les feuilles de présence
        return "redirect:/fp";
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

    @GetMapping("/fp/{mois}")
    public String lignep(@PathVariable String mois, Model model, HttpSession session) {

        if (session.getAttribute("etudiantconnect") == null) {
            return "redirect:/home";
        }

        Etudiant etudiantconnect = (Etudiant) session.getAttribute("etudiantconnect");
        List<Feuille> feuilles = etudiantconnect.getFeuillesDePresence();
        etudiantconnect = ER.findByMail(etudiantconnect.getMail());
        model.addAttribute("nom", etudiantconnect.getNom());
        model.addAttribute("prenom", etudiantconnect.getPrenom());
        model.addAttribute("feuilles", feuilles);

        Feuille feuille = FR.findByMois(mois);
        List<ligne> lignes = feuille.getLignes();

        model.addAttribute("feuille", feuille);
        model.addAttribute("lignes", lignes);

        return "ligne";
    }

    @PostMapping("/fp/{mois}/ajouterligne")
    public String ajouterligne(@PathVariable String mois, @ModelAttribute("ligne") ligne ligne,
            HttpSession session) {
        if (session.getAttribute("etudiantconnect") == null) {
            return "redirect:/home";
        }

        Etudiant etudiantconnect = (Etudiant) session.getAttribute("etudiantconnect");
        etudiantconnect = ER.findByMail(etudiantconnect.getMail());

        Feuille feuille = FR.findByMois(mois);

        ligne.setFeuilleDePresence(feuille);

        feuille.getLignes().add(ligne);

        FR.save(feuille);
        return "redirect:/fp/" + mois;
    }

    @GetMapping("/delete/{mois}/{id}")
    public String deleteFeuilleLigne(@PathVariable("id") Long id, @PathVariable("mois") String mois) {
        LS.delete(id);
        return "redirect:/fp/" + mois;
    }

}
