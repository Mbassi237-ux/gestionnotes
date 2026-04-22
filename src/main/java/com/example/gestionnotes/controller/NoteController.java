package com.example.gestionnotes.controller;

import com.example.gestionnotes.entity.Note;
import com.example.gestionnotes.entity.Etudiant;
import com.example.gestionnotes.entity.Matiere;
import com.example.gestionnotes.service.NoteService;
import com.example.gestionnotes.service.EtudiantService;
import com.example.gestionnotes.service.MatiereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    private final EtudiantService etudiantService;
    private final MatiereService matiereService;

    public NoteController(NoteService noteService, EtudiantService etudiantService, MatiereService matiereService) {
        this.noteService = noteService;
        this.etudiantService = etudiantService;
        this.matiereService = matiereService;
    }

    // Liste de toutes les notes
    @GetMapping
    public String list(Model model) {
        model.addAttribute("notes", noteService.getAll());
        return "notes";
    }

    // Formulaire pour ajouter une note
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("note", new Note());
        model.addAttribute("etudiants", etudiantService.getAll());
        model.addAttribute("matieres", matiereService.getAll());
        return "edit-note";
    }

    // Formulaire pour modifier une note existante
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        model.addAttribute("etudiants", etudiantService.getAll());
        model.addAttribute("matieres", matiereService.getAll());
        return "edit-note";
    }

    // Enregistrer une note (nouvelle ou modifiée)
    @PostMapping("/save")
    public String save(@ModelAttribute Note note) {
        noteService.save(note);
        return "redirect:/notes";
    }

    // Supprimer une note
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/notes";
    }
}
