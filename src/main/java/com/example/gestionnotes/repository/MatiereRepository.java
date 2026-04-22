package com.example.gestionnotes.repository;

import com.example.gestionnotes.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    // JpaRepository fournit déjà findAll(), findById(), save(), deleteById()
}
