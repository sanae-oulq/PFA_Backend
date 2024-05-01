package com.postgresql.ytdemo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class EnquetePublique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datePV;
    private String membre1;
    private String membre2;
    private String membre3;
    private String membre4;
    private String membre5;
    private String membre6;
    
    @OneToOne(mappedBy = "enquetePublique")
    private DemandeAutorisation demandeAutorisation;

	public EnquetePublique(LocalDate datePV, String membre1, String membre2, String membre3, String membre4,
			String membre5, String membre6, DemandeAutorisation demandeAutorisation) {
		super();
		this.datePV = datePV;
		this.membre1 = membre1;
		this.membre2 = membre2;
		this.membre3 = membre3;
		this.membre4 = membre4;
		this.membre5 = membre5;
		this.membre6 = membre6;
		this.demandeAutorisation = demandeAutorisation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatePV() {
		return datePV;
	}

	public void setDatePV(LocalDate datePV) {
		this.datePV = datePV;
	}

	public String getMembre1() {
		return membre1;
	}

	public void setMembre1(String membre1) {
		this.membre1 = membre1;
	}

	public String getMembre2() {
		return membre2;
	}

	public void setMembre2(String membre2) {
		this.membre2 = membre2;
	}

	public String getMembre3() {
		return membre3;
	}

	public void setMembre3(String membre3) {
		this.membre3 = membre3;
	}

	public String getMembre4() {
		return membre4;
	}

	public void setMembre4(String membre4) {
		this.membre4 = membre4;
	}

	public String getMembre5() {
		return membre5;
	}

	public void setMembre5(String membre5) {
		this.membre5 = membre5;
	}

	public String getMembre6() {
		return membre6;
	}

	public void setMembre6(String membre6) {
		this.membre6 = membre6;
	}

	public DemandeAutorisation getDemandeAutorisation() {
		return demandeAutorisation;
	}

	public void setDemandeAutorisation(DemandeAutorisation demandeAutorisation) {
		this.demandeAutorisation = demandeAutorisation;
	}
    

}