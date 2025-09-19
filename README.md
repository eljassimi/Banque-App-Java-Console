# Banque-App-Java-Console

Ce projet est une application console développée en **Java 8** qui simule un système de gestion de comptes bancaires pour une banque.  
Elle permet d'automatiser et de gérer efficacement les comptes et leurs opérations.

---

## 🎯 Contexte du Projet
L'objectif est de fournir un système informatisé simple pour gérer les opérations bancaires courantes telles que :
- Versements
- Retraits
- Virements

L'application distingue différents types de comptes (courants et épargne).

---

## 🏗️ Structure de l'Application
L'application est conçue en suivant une **architecture en couches** pour séparer les responsabilités et améliorer la maintenabilité :

- **Couche Présentation (UI/Menu)** : Gère toutes les interactions avec l'utilisateur via un menu interactif dans la console.
- **Couche Métier (Service)** : Contient la logique métier (création de compte, gestion des opérations, virements, etc.).
- **Couche Données (DAO/Repository)** : Simule la persistance des données en mémoire avec `HashMap` ou `ArrayList`.
- **Couche Modèle (Entités)** : Représente les objets principaux (`Compte`, `Operation`, etc.).
- **Couche Utilitaire** : Fournit des fonctions transversales (validation des entrées, etc.).

---

## 📊 Diagramme de Classes
Voici le diagramme de classes UML illustrant la structure et les relations du projet :

![Diagramme UML](diagramme.jpg)
---

## 📦 Description des Classes

### 🔹 Comptes
#### `Compte` (abstraite)
- **Attributs** :
    - `code : String` → Identifiant unique (`CPT-XXXXX`)
    - `solde : double` → Solde actuel
    - `listeOperations : List<Operation>` → Historique des opérations
- **Méthodes abstraites** :
    - `retirer(double montant)`
    - `calculerInteret()`
    - `afficherDetails()`

#### `CompteCourant`
- Hérite de `Compte`
- **Attribut** : `decouvert : double`
- **Règles métier** :
    - Retrait possible tant que `solde - montant >= -decouvert`
    - `calculerInteret()` retourne toujours 0

#### `CompteEpargne`
- Hérite de `Compte`
- **Attribut** : `tauxInteret : double`
- **Règles métier** :
    - Retrait uniquement si `solde >= montant`
    - `calculerInteret()` basé sur le solde et le taux

---

### 🔹 Opérations
#### `Operation` (abstraite)
- **Attributs** :
    - `numero : UUID`
    - `date : LocalDate`
    - `montant : double`

#### `Versement`
- Hérite de `Operation`
- **Attribut** : `source : String` (ex: "Salaire", "Dépôt espèces")

#### `Retrait`
- Hérite de `Operation`
- **Attribut** : `destination : String` (ex: "ATM", "Chèque")

---

## ⚙️ Fonctionnalités Principales
- Créer un compte (courant ou épargne)
- Effectuer un **versement**
- Effectuer un **retrait**
- Effectuer un **virement** (retrait sur compte source + versement sur compte destination)
- Consulter le **solde** d’un compte
- Consulter l’**historique des opérations**
- Quitter l’application

---

## 🛠️ Spécifications Techniques
- **Langage** : Java 8
- **Stockage des données** : `HashMap` en mémoire (les données sont perdues à la fermeture)
- **Gestion des dates** : `java.time.LocalDate`
- **Gestion des erreurs** : `try-catch` (ex: soldes insuffisants, saisies invalides)
- **Validations** :
    - Montants > 0
    - Format de compte (`CPT-XXXXX`) validé avec regex
    - Vérification de l’existence d’un compte avant opération

---

## ▶️ Lancer l’Application

### 1. Compiler
```bash
javac --source-path src -d out src/com/banque/Main.java
