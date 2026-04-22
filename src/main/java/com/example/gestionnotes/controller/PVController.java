package com.example.gestionnotes.controller;

import com.example.gestionnotes.entity.Matiere;
import com.example.gestionnotes.entity.Note;
import com.example.gestionnotes.service.MatiereService;
import com.example.gestionnotes.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pv")
public class PVController {

    private final MatiereService matiereService;
    private final NoteService noteService;

    public PVController(MatiereService matiereService, NoteService noteService) {
        this.matiereService = matiereService;
        this.noteService = noteService;
    }

    // Liste toutes les matières pour accéder aux PV
    @GetMapping
    public String listPV(Model model) {
        model.addAttribute("matieres", matiereService.getAll());
        return "pv"; // page Thymeleaf pour lister les PV
    }

    // Affiche le PV d'une matière spécifique
    @GetMapping("/view/{id}")
    public String viewPV(@PathVariable Long id, Model model) {
        Matiere matiere = matiereService.getById(id);
        if (matiere != null) {
            List<Note> notes = noteService.findByMatiere(matiere);
            // Tri alphabétique par nom d'étudiant
            notes.sort((n1, n2) -> n1.getEtudiant().getNom().compareToIgnoreCase(n2.getEtudiant().getNom()));
            model.addAttribute("matiere", matiere);
            model.addAttribute("notes", notes);
        }
        return "view-pv"; // page Thymeleaf pour afficher le PV d'une matière
    }
}
