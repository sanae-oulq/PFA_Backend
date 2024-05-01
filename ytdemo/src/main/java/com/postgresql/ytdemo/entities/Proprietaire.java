package com.postgresql.ytdemo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CIN;
    private String nom;
    private String prenom;
    private String adresse;
    private String genre;
    
    @OneToMany(mappedBy = "proprietaire")
    private List<DemandeAutorisation> demandesAutorisation = new ArrayList<>();

    @OneToMany(mappedBy = "proprietaire")
    private List<Document> documents = new ArrayList<>();

    // Constructeur avec arguments
    public Proprietaire(String CIN, String nom, String prenom, String adresse, String genre) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.genre = genre;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<DemandeAutorisation> getDemandesAutorisation() {
        return demandesAutorisation;
    }

    public void setDemandesAutorisation(List<DemandeAutorisation> demandesAutorisation) {
        this.demandesAutorisation = demandesAutorisation;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
