package com.example.gestionnotes.entity;

import jakarta.persistence.*;

@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String intitule;

    public Matiere(){}

    public Long getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getIntitule(){
        return intitule;
    }

    public void setIntitule(String intitule){
        this.intitule = intitule;
    }
}
