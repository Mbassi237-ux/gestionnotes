package com.example.gestionnotes.repository;

import com.example.gestionnotes.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    // JpaRepository fournit déjà findAll(), findById(), save(), deleteById()
}
