package com.example.gestionnotes.service;

import com.example.gestionnotes.entity.Matiere;
import com.example.gestionnotes.entity.Note;
import com.example.gestionnotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    // Récupère toutes les notes triées par nom d'étudiant
    public List<Note> getAll() {
        return repository.findAll(Sort.by("etudiant.nom"));
    }

    // Récupère une note par id
    public Note getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Enregistre ou met à jour une note
    public void save(Note note) {
        repository.save(note);
    }

    // Supprime une note par id
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Récupère toutes les notes d'une matière triées par nom d'étudiant
    public List<Note> findByMatiere(Matiere matiere) {
        return repository.findByMatiere(matiere, Sort.by("etudiant.nom"));
    }
}
