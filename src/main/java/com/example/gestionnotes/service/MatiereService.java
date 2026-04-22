package com.example.gestionnotes.service;

import com.example.gestionnotes.entity.Matiere;
import com.example.gestionnotes.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository repository;

    // Retourne toutes les matières triées par nom
    public List<Matiere> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "nom"));
    }

    // Retourne une matière par son ID
    public Matiere getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Enregistre une matière (nouvelle ou modification)
    public void save(Matiere matiere) {
        repository.save(matiere);
    }

    // Supprime une matière par son ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
