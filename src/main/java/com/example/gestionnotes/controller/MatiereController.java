package com.example.gestionnotes.controller;

import com.example.gestionnotes.entity.Matiere;
import com.example.gestionnotes.service.MatiereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matieres")
public class MatiereController {

    private final MatiereService service;

    public MatiereController(MatiereService service) {
        this.service = service;
    }

    // Affiche la liste des matières
    @GetMapping
    public String list(Model model) {
        model.addAttribute("matieres", service.getAll());
        return "matieres"; // nom de la page Thymeleaf
    }

    // Formulaire pour ajouter une matière
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("matiere", new Matiere());
        return "edit-matiere";
    }

    // Enregistrer une matière (nouvelle ou modifiée)
    @PostMapping("/save")
    public String save(@ModelAttribute Matiere matiere) {
        service.save(matiere);
        return "redirect:/matieres";
    }

    // Formulaire pour modifier une matière existante
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("matiere", service.getById(id));
        return "edit-matiere";
    }

    // Supprimer une matière
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/matieres";
    }
}
