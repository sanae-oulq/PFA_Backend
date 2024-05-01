package com.postgresql.ytdemo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Propriete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_propriete;
    private double surface;
    private String lib_prov;
    private String lib_comm;
    private String adresse;
    private String genre;
    
    @OneToOne
    @JoinColumn(name = "proprietaire_id")
    private Proprietaire proprietaire;

	public Propriete(String nom_propriete, double surface, String lib_prov, String lib_comm, String adresse,
			String genre, Proprietaire proprietaire) {
		super();
		this.nom_propriete = nom_propriete;
		this.surface = surface;
		this.lib_prov = lib_prov;
		this.lib_comm = lib_comm;
		this.adresse = adresse;
		this.genre = genre;
		this.proprietaire = proprietaire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom_propriete() {
		return nom_propriete;
	}

	public void setNom_propriete(String nom_propriete) {
		this.nom_propriete = nom_propriete;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getLib_prov() {
		return lib_prov;
	}

	public void setLib_prov(String lib_prov) {
		this.lib_prov = lib_prov;
	}

	public String getLib_comm() {
		return lib_comm;
	}

	public void setLib_comm(String lib_comm) {
		this.lib_comm = lib_comm;
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

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
    
    
    
    

   
}
