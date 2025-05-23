# IMC Calculator - Application Web Fullstack
Application web permettant de calculer l’Indice de Masse Corporelle (IMC) d’une personne.  
L’application est composée d’un frontend en React, d’un backend en Spring Boot, et utilise une base de données SQL. Le tout est containerisé avec Docker pour un déploiement facile.

## Fonctionnalités

- Saisie des données : poids (kg) et taille (cm)
- Calcul automatique de l’IMC et affichage de la catégorie (maigreur, normal, surpoids, obésité)
- Stockage des résultats dans une base SQL
- Consultation de l’historique des calculs
- Possibilité de supprimer son historique ou un seul calcul
- Interface utilisateur responsive et moderne (React)
- Backend RESTful en Spring Boot
- Déploiement via Docker Compose

## 🛠️ Technologies

- **Frontend** : React
- **Backend** : JAVA avec Spring Boot, Spring Data JPA
- **Base de données** : MySQL 
- **Conteneurisation** : Docker, Docker Compose

## Prérequis 

- [Docker](https://www.docker.com/get-started) installé sur la machine

## Pour lancer l'application

- Se rendre à la racine du projet
- Construire et lancer les conteneurs Docker avec "docker-compose up --build"
- se rendre ensuite à l'adresse "http://localhost:3000" 


