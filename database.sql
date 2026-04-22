-- Création de la base de données
CREATE DATABASE IF NOT EXISTS gestionnotes;

-- Utiliser la base
USE gestionnotes;

-- Table des étudiants
CREATE TABLE IF NOT EXISTS etudiant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricule VARCHAR(50) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL
);

-- Table des matières
CREATE TABLE IF NOT EXISTS matiere (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    intitule VARCHAR(255)
);

-- Table des notes
CREATE TABLE IF NOT EXISTS note (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    etudiant_id BIGINT,
    matiere_id BIGINT,
    cc DOUBLE,
    sn DOUBLE,
    tp DOUBLE,
    total DOUBLE,
    appreciation VARCHAR(50),

    CONSTRAINT fk_etudiant
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant(id)
    ON DELETE CASCADE,

    CONSTRAINT fk_matiere
    FOREIGN KEY (matiere_id)
    REFERENCES matiere(id)
    ON DELETE CASCADE
);
