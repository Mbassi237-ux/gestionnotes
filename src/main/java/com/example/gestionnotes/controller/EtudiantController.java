package com.example.gestionnotes.controller;

import com.example.gestionnotes.entity.Etudiant;
import com.example.gestionnotes.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    // Affiche la liste des étudiants
    @GetMapping
    public String list(Model model) {
        model.addAttribute("etudiants", service.getAll());
        return "etudiants"; // nom de la page Thymeleaf
    }

    // Formulaire pour ajouter un étudiant
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "edit-etudiant";
    }

    // Enregistrer un étudiant (nouveau ou modifié)
    @PostMapping("/save")
    public String save(@ModelAttribute Etudiant etudiant) {
        service.save(etudiant);
        return "redirect:/etudiants";
    }

    // Formulaire pour modifier un étudiant existant
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("etudiant", service.getById(id));
        return "edit-etudiant";
    }

    // Supprimer un étudiant
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/etudiants";
    }
}
