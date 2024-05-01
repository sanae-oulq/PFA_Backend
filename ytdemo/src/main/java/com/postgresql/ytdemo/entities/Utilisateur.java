package com.postgresql.ytdemo.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Utilisateur {
    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String email;

    @ManyToOne
    private Role role;

    @OneToMany
    @JoinColumn(name = "utilisateur_id")
    private List<Historique> historiques = new ArrayList<>();

    @ManyToOne
    private Utilisateur utilisateurParent;

    @OneToMany(mappedBy = "utilisateurParent")
    private List<Utilisateur> utilisateursEnfants = new ArrayList<>();

	public Utilisateur(String nom, String prenom, String login, String password, String email, Role role,
			List<Historique> historiques, Utilisateur utilisateurParent, List<Utilisateur> utilisateursEnfants) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
		this.historiques = historiques;
		this.utilisateurParent = utilisateurParent;
		this.utilisateursEnfants = utilisateursEnfants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Utilisateur getUtilisateurParent() {
		return utilisateurParent;
	}

	public void setUtilisateurParent(Utilisateur utilisateurParent) {
		this.utilisateurParent = utilisateurParent;
	}

	public List<Utilisateur> getUtilisateursEnfants() {
		return utilisateursEnfants;
	}

	public void setUtilisateursEnfants(List<Utilisateur> utilisateursEnfants) {
		this.utilisateursEnfants = utilisateursEnfants;
	}

    
}
