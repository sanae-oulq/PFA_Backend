package com.postgresql.ytdemo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class DemandeAutorisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date_bo;
    private String libelle_procedure;
    private String lib_type_usage_eau;
    private double profondeur;
    private double coordonnees_x;
    private double coordonnees_y;
    private String etat;

    @ManyToOne
    private Utilisateur utilisateur;
    
    @OneToOne
    @JoinColumn(name = "enquetePublique_id")
    private EnquetePublique enquetePublique;
    
    @ManyToOne
    private Proprietaire proprietaire;


	public DemandeAutorisation(LocalDate date_bo, String libelle_procedure, String lib_type_usage_eau,
			double profondeur, double coordonnees_x, double coordonnees_y, String etat, Utilisateur utilisateur) {
		super();
		this.date_bo = date_bo;
		this.libelle_procedure = libelle_procedure;
		this.lib_type_usage_eau = lib_type_usage_eau;
		this.profondeur = profondeur;
		this.coordonnees_x = coordonnees_x;
		this.coordonnees_y = coordonnees_y;
		this.etat = etat;
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate_bo() {
		return date_bo;
	}

	public void setDate_bo(LocalDate date_bo) {
		this.date_bo = date_bo;
	}

	public String getLibelle_procedure() {
		return libelle_procedure;
	}

	public void setLibelle_procedure(String libelle_procedure) {
		this.libelle_procedure = libelle_procedure;
	}

	public String getLib_type_usage_eau() {
		return lib_type_usage_eau;
	}

	public void setLib_type_usage_eau(String lib_type_usage_eau) {
		this.lib_type_usage_eau = lib_type_usage_eau;
	}

	public double getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(double profondeur) {
		this.profondeur = profondeur;
	}

	public double getCoordonnees_x() {
		return coordonnees_x;
	}

	public void setCoordonnees_x(double coordonnees_x) {
		this.coordonnees_x = coordonnees_x;
	}

	public double getCoordonnees_y() {
		return coordonnees_y;
	}

	public void setCoordonnees_y(double coordonnees_y) {
		this.coordonnees_y = coordonnees_y;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public EnquetePublique getEnquetePublique() {
		return enquetePublique;
	}

	public void setEnquetePublique(EnquetePublique enquetePublique) {
		this.enquetePublique = enquetePublique;
	}
    
	 public Proprietaire getProprietaire() {
	        return proprietaire;
	    }

	    public void setProprietaire(Proprietaire proprietaire) {
	        this.proprietaire = proprietaire;
	    }
}
