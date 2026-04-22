package com.example.gestionnotes.repository;

import com.example.gestionnotes.entity.Matiere;
import com.example.gestionnotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    // Liste des notes pour une matière, triables avec Sort
    List<Note> findByMatiere(Matiere matiere, Sort sort);

    // Liste de toutes les notes (optionnel si tu veux un tri dans le service)
    List<Note> findAll(Sort sort);
}
