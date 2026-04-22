package com.example.gestionnotes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0) @Max(20)
    private Double cc; // /20

    @Min(0) @Max(40)
    private Double sn; // /40

    @Min(0) @Max(40)
    private Double tp; // /40

    @ManyToOne
    @NotNull(message = "Étudiant obligatoire")
    private Etudiant etudiant;

    @ManyToOne
    @NotNull(message = "Matière obligatoire")
    private Matiere matiere;

    public Note() {}

    public Note(Double cc, Double sn, Double tp, Etudiant etudiant, Matiere matiere) {
        this.cc = cc;
        this.sn = sn;
        this.tp = tp;
        this.etudiant = etudiant;
        this.matiere = matiere;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getCc() { return cc; }
    public void setCc(Double cc) { this.cc = cc; }

    public Double getSn() { return sn; }
    public void setSn(Double sn) { this.sn = sn; }

    public Double getTp() { return tp; }
    public void setTp(Double tp) { this.tp = tp; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public Matiere getMatiere() { return matiere; }
    public void setMatiere(Matiere matiere) { this.matiere = matiere; }

    // Calcul total /100
    public Double getTotal() {
        return (cc != null ? cc : 0) + (sn != null ? sn : 0) + (tp != null ? tp : 0);
    }

    // Calcul appréciation
    public String getAppreciation() {
        double total = getTotal();
        if (total <= 34) return "NC";
        if (total <= 49) return "CANT";
        if (total <= 54) return "CA";
        if (total <= 59) return "C";
        if (total <= 64) return "C+";
        if (total <= 69) return "B-";
        if (total <= 74) return "B";
        if (total <= 79) return "B+";
        if (total <= 84) return "A-";
        if (total <= 89) return "A";
        return "A+";
    }
}
