package com.example.gestionnotes.service;

import com.example.gestionnotes.entity.Etudiant;
import com.example.gestionnotes.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository repository;

    // Retourne tous les étudiants triés par nom
    public List<Etudiant> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "nom"));
    }

    // Retourne un étudiant par son ID
    public Etudiant getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Enregistre un étudiant (nouveau ou modification)
    public void save(Etudiant etudiant) {
        repository.save(etudiant);
    }

    // Supprime un étudiant par son ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
