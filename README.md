README
Application de Gestion des notes
1. Présentation du projet
Ce projet est une application web de gestion des notes des étudiants développée avec Spring
Boot.
L'application permet de :
• gérer les étudiants
• gérer les matières
• enregistrer les notes des étudiants
• consulter les résultats
• afficher les procès-verbaux (PV) des notes par matière
Les étudiants sont affichés par ordre alphabétique, et les tableaux utilisent des numéros
séquentiels pour l’affichage.
2. Technologies utilisées
Le projet utilise les technologies suivantes :
• Java 17
• Spring Boot
• Spring Data JPA
• Thymeleaf
• HTML / CSS
• MySQL / MariaDB
• Maven
3. Prérequis
Avant d'exécuter le projet, il faut installer les outils suivants :
1. Java
Installer Java 17 ou supérieur
Vérifier l'installation :
java -version2. Maven
Vérifier que Maven est installé : mvn -version
3. MySQL ou MariaDB
Installer un serveur de base de données : MySQL ou MariaDB
4. IDE (optionnel)
Pour modifier le projet, on peut utiliser : Visual Studio Code, IntelliJ, Eclipse.
4. Installation du projet
1. Cloner ou copier le projet
Placer le dossier du projet dans votre ordinateur.
Exemple : gestionnotes/
2. Structure du projet
Le projet est organisé comme suit :

gestionnotes
│
├── src
│ └── main
│├── java
││ └── com.example.gestionnotes
││
├── controller
││
├── entity
││
├── repository
││
└── service
││
│└── resources
│├── templates
│├── static
││ └── css
│└── application.properties
│
└── pom.xml5. Configuration de la base de données

Créer une base de données dans MySQL ou MariaDB : CREATE DATABASE gestion_notes;
Modifier le fichier : src/main/resources/application.properties
Exemple de configuration :
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_notes
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
6. Lancer l'application
Dans le dossier du projet, exécuter la commande suivante : mvn spring-boot:run
Si tout fonctionne correctement, vous verrez un message indiquant que Spring Boot a démarré.
7. Accéder à l'application
Ouvrir un navigateur et aller à l'adresse suivante : http://localhost:8080
La page d'accueil de l'application apparaît.
